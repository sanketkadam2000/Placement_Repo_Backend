package com.ram.repository;

import org.springframework.data.repository.CrudRepository;

import com.ram.model.College;  

public interface CollegeRepository extends CrudRepository<College, Integer>
{

}
