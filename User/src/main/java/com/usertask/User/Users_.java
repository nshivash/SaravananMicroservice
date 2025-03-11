package com.usertask.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users_")
public class Users_ {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_Id")
	private int userId;
	@Column(name="user_Name")
	private String userName;
	
	public Users_() {}
	
//	public Users_(int user_Id, String user_Name) {
//		super();
//		this.user_Id = user_Id;
//		this.user_Name = user_Name;
//	}
	public int getUser_Id() {
		return userId;
	}
	public void setUser_Id(int user_Id) {
		this.userId = user_Id;
	}
	public String getUser_Name() {
		return userName;
	}
	public void setUser_Name(String user_Name) {
		this.userName = user_Name;
	}	
}
