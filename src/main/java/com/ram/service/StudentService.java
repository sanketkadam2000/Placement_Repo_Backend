package com.ram.service;

import java.util.List;

import com.ram.model.Student;

public interface StudentService
{
	public abstract Student createStudent(Student student);

	public abstract void updateStudent(Student student);
	
	public abstract Student getStudent(int student_id);
	
	public abstract List<Student> getStudents();
	
	public abstract void deleteStudent(int student_id);
	
	public abstract boolean isStudentExist(int student_id);
	
	public abstract int getCount();
}
