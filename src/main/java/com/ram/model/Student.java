package com.ram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String student_first_name;
	private String student_last_name;
	private String student_email;
	private String student_phone_no;
	private int student_college_id;
	private int student_course_id;

	

	public int getStudent_id() {
		return student_id;
	}



	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}



	public String getStudent_first_name() {
		return student_first_name;
	}



	public void setStudent_first_name(String student_first_name) {
		this.student_first_name = student_first_name;
	}



	public String getStudent_last_name() {
		return student_last_name;
	}



	public void setStudent_last_name(String student_last_name) {
		this.student_last_name = student_last_name;
	}



	public String getStudent_email() {
		return student_email;
	}



	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}



	public String getStudent_phone_no() {
		return student_phone_no;
	}



	public void setStudent_phone_no(String student_phone_no) {
		this.student_phone_no = student_phone_no;
	}



	public int getStudent_college_id() {
		return student_college_id;
	}



	public void setStudent_college_id(int student_college_id) {
		this.student_college_id = student_college_id;
	}



	public int getStudent_course_id() {
		return student_course_id;
	}



	public void setStudent_course_id(int student_course_id) {
		this.student_course_id = student_course_id;
	}



	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_first_name=" + student_first_name
				+ ", student_last_name=" + student_last_name + ", student_email=" + student_email
				+ ", student_phone_no=" + student_phone_no + ", student_college_id=" + student_college_id
				+ ", student_course_id=" + student_course_id + "]";
	}


}
