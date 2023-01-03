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

import com.ram.exception.UserNotfoundException;
import com.ram.model.User;
import com.ram.service.UserService;

@RestController
//@CrossOrigin(origins="http://localhost:3001")
@CrossOrigin(origins="*")
public class UserServiceController
{
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody User user)
	{
		user = userService.createUser(user);
		return new ResponseEntity<>("User is created successfully with id = " +user.getUser_id(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@PathVariable("id") int id,
			@RequestBody User user)
	{
		boolean isUserExist =  userService.isUserExist(id);
		if (isUserExist)
		{
			 user.setUser_id(id);
			 userService.updateUser( user);
			return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new UserNotfoundException();
		}

	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getUser(@PathVariable("id") int id)
	{
		boolean isUserExist =  userService.isUserExist(id);
		if (isUserExist)
		{
			User user =  userService.getUser(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else
		{
			throw new UserNotfoundException();
		}

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<Object> getUsers()
	{
		List<User>  userList =  userService.getUsers();
		return new ResponseEntity<>( userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id)
	{
		boolean isUserExist =  userService.isUserExist(id);
		if (isUserExist)
		{
			 userService.deleteUser(id);
			return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new UserNotfoundException();
		}

	}

}
