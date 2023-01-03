package com.ram.repository;

import org.springframework.data.repository.CrudRepository;

import com.ram.model.Student;  

public interface StudentRepository extends CrudRepository<Student, Integer>
{

}
