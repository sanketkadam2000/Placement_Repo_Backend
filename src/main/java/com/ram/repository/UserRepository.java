package com.ram.repository;

import org.springframework.data.repository.CrudRepository;

import com.ram.model.User;  

public interface UserRepository extends CrudRepository<User, Integer>
{

}
