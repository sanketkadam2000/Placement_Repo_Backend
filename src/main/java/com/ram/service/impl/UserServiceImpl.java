package com.ram.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.User;
import com.ram.repository.UserRepository;
import com.ram.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User  user) {
		
		return  userRepository.save( user);
	}

	@Override
	public void updateUser(User  user) {
		
		 userRepository.save( user);

	}

	@Override
	public User getUser(int  user_id) {
		Optional<User> optional =  userRepository.findById( user_id);
		User  user = optional.get();
		return  user;
	}

	@Override
	public List<User> getUsers() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void deleteUser(int user_id) {
		
		 userRepository.deleteById( user_id);
	}

	@Override
	public boolean isUserExist(int  user_id) {
		
		return  userRepository.existsById( user_id);
	}
	
	@Override
	public int getCount() {
		return (int) userRepository.count();
	}
}
