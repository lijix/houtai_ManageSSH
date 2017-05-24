package com.kind.bean;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



public class Students {
	 private Integer sid;
	   private String sname;
	   private String gender;
	   private Date birthday;
	   private String address;
	   
	   
	public Students() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday
				+ ", address=" + address + "]";
	}

   
	
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	   
}
