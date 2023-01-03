package com.ram.repository;

import org.springframework.data.repository.CrudRepository;

import com.ram.model.Course;  

public interface CourseRepository extends CrudRepository<Course, Integer>
{

}
