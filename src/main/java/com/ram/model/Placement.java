package com.ram.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  
public class Placement

{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int placement_id;
	private String placement_name;
	private Date local_date;
	private String qualification;
	private int year;
	public long getPlacement_id() {
		return placement_id;
	}
	public void setPlacement_id(int placement_id) {
		this.placement_id = placement_id;
	}
	public String getPlacement_name() {
		return placement_name;
	}
	public void setPlacement_name(String placement_name) {
		this.placement_name = placement_name;
	}
	public Date getLocal_date() {
		return local_date;
	}
	public void setLocal_date(Date local_date) {
		this.local_date = local_date;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Placement [placement_id=" + placement_id + ", placement_name=" + placement_name + ", local_date="
				+ local_date + ", qualification=" + qualification + ", year=" + year + "]";
	}
	

}

