package com.ram.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  
public class Dashboard
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dashboard_id;
	private String name;
	private int count;
	public int getDashboard_id() {
		return dashboard_id;
	}
	public void setDashboard_id(int dashboard_id) {
		this.dashboard_id = dashboard_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Dashboard [dashboard_id=" + dashboard_id + ", name=" + name + ", count=" + count + "]";
	}
	
	
}
