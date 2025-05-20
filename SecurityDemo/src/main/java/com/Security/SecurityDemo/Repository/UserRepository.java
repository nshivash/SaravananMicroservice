package com.Security.SecurityDemo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Security.SecurityDemo.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);

}
