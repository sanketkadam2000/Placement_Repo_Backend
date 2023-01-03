package com.ram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  
public class College

{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int college_id;
	private String college_name;
	private String location;
	public long getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "College [college_id=" + college_id + ", college_name=" + college_name + ", location=" + location + "]";
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

