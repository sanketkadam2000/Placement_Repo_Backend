package com.ram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  
public class Admin
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_id;
	private String admin_name;
	private String admin_password;
	

	
	public int getAdmin_id() {
		return admin_id;
	}



	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}



	public String getAdmin_name() {
		return admin_name;
	}



	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}



	public String getAdmin_password() {
		return admin_password;
	}



	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}



	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_password=" + admin_password
				+ "]";
	}

	


//
//	@Override
//	public String toString()
//	{
//		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary
//				+ "]";
//	}
//
}
