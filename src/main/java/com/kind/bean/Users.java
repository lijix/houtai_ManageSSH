package com.kind.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class Users {
	  private int uid;
	    private String username;
	    private String password;
	    
	    
		public Users() {
			super();
		}
		
		@Override
		public String toString() {
			return "Users [uid=" + uid + ", username=" + username + ", password=" + password + "]";
		}
		  
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	    
}
