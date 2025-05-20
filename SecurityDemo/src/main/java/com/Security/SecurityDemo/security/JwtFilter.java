package com.Security.SecurityDemo.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Security.SecurityDemo.Config.CustomUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	JwtUtils jwtutil;
	 
	@Autowired 
	CustomUserDetailService customuserdetailservice;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");
		if(header==null||!header.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		String token = header.substring(7);
		try{
			System.out.println(token);
			String username = jwtutil.extractUsername(token);
			if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {		
				UserDetails userdetails=customuserdetailservice.loadUserByUsername(username);
				if(jwtutil.validateToken(token, userdetails)) {
					UsernamePasswordAuthenticationToken authenticationtoken=
							new UsernamePasswordAuthenticationToken(userdetails.getUsername(),
																	userdetails.getPassword(),
																	userdetails.getAuthorities()
																	);
					authenticationtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authenticationtoken);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		filterChain.doFilter(request, response);
	}
}
