package com.ram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.exception.AdminNotfoundException;
import com.ram.model.Admin;
import com.ram.service.AdminService;

@RestController
//@CrossOrigin(origins="http://localhost:3001")
@CrossOrigin(origins="*")
public class AdminServiceController
{
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/admins", method = RequestMethod.POST)
	public ResponseEntity<Object> createAdmin(@RequestBody Admin admin)
	{
		admin = adminService.createAdmin(admin);
		return new ResponseEntity<>("Admin is created successfully with id = " +admin.getAdmin_id(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admins/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAdmin(@PathVariable("id") int id,
			@RequestBody Admin admin)
	{
		boolean isAdminExist = adminService.isAdminExist(id);
		if (isAdminExist)
		{
			admin.setAdmin_id(id);
			adminService.updateAdmin(admin);
			return new ResponseEntity<>("Admin is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new AdminNotfoundException();
		}

	}

	@RequestMapping(value = "/admins/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAdmin(@PathVariable("id") int id)
	{
		boolean isAdminExist = adminService.isAdminExist(id);
		if (isAdminExist)
		{
			Admin admin = adminService.getAdmin(id);
			return new ResponseEntity<>(admin, HttpStatus.OK);
		}
		else
		{
			throw new AdminNotfoundException();
		}

	}

	@RequestMapping(value = "/admins", method = RequestMethod.GET)
	public ResponseEntity<Object> getAdmins()
	{
		List<Admin> adminList = adminService.getAdmins();
		return new ResponseEntity<>(adminList, HttpStatus.OK);
	}

	@RequestMapping(value = "/admins/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAdmin(@PathVariable("id") int id)
	{
		boolean isAdminExist = adminService.isAdminExist(id);
		if (isAdminExist)
		{
			adminService.deleteAdmin(id);
			return new ResponseEntity<>("Admin is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new AdminNotfoundException();
		}

	}

}
