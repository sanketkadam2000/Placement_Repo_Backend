package com.ram.service;

import java.util.List;

import com.ram.model.User;

public interface UserService
{
	public abstract User createUser(User user);

	public abstract void updateUser(User user);
	
	public abstract User getUser(int user_id);
	
	public abstract List<User> getUsers();
	
	public abstract void deleteUser(int user_id);
	
	public abstract boolean isUserExist(int user_id);
	
	public abstract int getCount();
}
