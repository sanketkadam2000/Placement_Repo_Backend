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

import com.ram.exception.StudentNotfoundException;
import com.ram.model.Student;
import com.ram.service.StudentService;

@RestController
//@CrossOrigin(origins="http://localhost:3001")
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT, RequestMethod.POST,RequestMethod.PATCH})
public class StudentServicesController
{
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student)
	{
		student = studentService.createStudent(student);
		return new ResponseEntity<>("Student is created successfully with id = " +student.getStudent_id(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") int student_id,
			@RequestBody Student student)
	{
		boolean isStudentExist = studentService.isStudentExist(student_id);
		if (isStudentExist)
		{
			student.setStudent_id(student_id);
			studentService.updateStudent(student);
			return new ResponseEntity<>("Student is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new StudentNotfoundException();
		}

	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudent(@PathVariable("id") int student_id)
	{
		boolean isStudentExist = studentService.isStudentExist(student_id);
		if (isStudentExist)
		{
			Student student = studentService.getStudent(student_id);
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
		else
		{
			throw new StudentNotfoundException();
		}

	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudents()
	{
		List<Student> studentList = studentService.getStudents();
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") int student_id)
	{
		boolean isEmployeeExist = studentService.isStudentExist(student_id);
		if (isEmployeeExist)
		{
			studentService.deleteStudent(student_id);
			return new ResponseEntity<>("Student is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new StudentNotfoundException();
		}

	}

}
