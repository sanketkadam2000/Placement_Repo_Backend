package com.ram.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.Admin;
import com.ram.repository.AdminRepository;
import com.ram.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin createAdmin(Admin admin) {
		
		return adminRepository.save(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		
		adminRepository.save(admin);

	}

	@Override
	public Admin getAdmin(int admin_id) {
		Optional<Admin> optional = adminRepository.findById(admin_id);
		Admin admin = optional.get();
		return admin;
	}

	@Override
	public List<Admin> getAdmins() {
		
		return (List<Admin>)adminRepository.findAll();
	}

	@Override
	public void deleteAdmin(int admin_id) {
		
		adminRepository.deleteById(admin_id);
	}

	@Override
	public boolean isAdminExist(int admin_id) {
		
		return adminRepository.existsById(admin_id);
	}
	
	@Override
	public int getCount() {
		return (int) adminRepository.count();
	}
}
