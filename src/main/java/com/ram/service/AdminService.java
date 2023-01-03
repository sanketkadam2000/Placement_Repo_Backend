package com.ram.service;

import java.util.List;

import com.ram.model.Admin;

public interface AdminService
{
	public abstract Admin createAdmin(Admin admin);

	public abstract void updateAdmin(Admin admin);
	
	public abstract Admin getAdmin(int admin_id);
	
	public abstract List<Admin> getAdmins();
	
	public abstract void deleteAdmin(int admin_id);
	
	public abstract boolean isAdminExist(int admin_id);
	
	public abstract int getCount();
}
