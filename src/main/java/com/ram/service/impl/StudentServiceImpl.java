package com.ram.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.Student;
import com.ram.repository.StudentRepository;
import com.ram.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		
		studentRepository.save(student);

	}

	@Override
	public Student getStudent(int student_id) {
		Optional<Student> optional = studentRepository.findById(student_id);
		Student student = optional.get();
		return student;
	}

	@Override
	public List<Student> getStudents() {
		
		return (List<Student>)studentRepository.findAll();
	}

	@Override
	public void deleteStudent(int student_id) {
		
		studentRepository.deleteById(student_id);
	}

	@Override
	public boolean isStudentExist(int student_id) {
		
		return studentRepository.existsById(student_id);
	}
	
	@Override
	public int getCount() {
		return (int) studentRepository.count();
	}
}
