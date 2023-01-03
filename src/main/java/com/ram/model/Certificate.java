package com.ram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity  
public class Certificate
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int certificate_id;
	private String start_date;
	private String end_date;
	private int year;
	
	
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public long getCertificate_id() {
		return certificate_id;
	}
	public void setCertificate_id(int certificate_id) {
		this.certificate_id = certificate_id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Certificate [certificate_id=" + certificate_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", year=" + year + "]";
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
