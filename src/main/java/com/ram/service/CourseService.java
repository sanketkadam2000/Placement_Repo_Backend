package com.ram.service;

import java.util.List;

import com.ram.model.Course;

public interface CourseService
{
	public abstract Course createCourse(Course course);

	public abstract void updateCourse(Course course);
	
	public abstract Course getCourse(int id);
	
	public abstract List<Course> getCourses();
	
	public abstract void deleteCourse(int id);
	
	public abstract boolean isCourseExist(int id);
	
	public abstract int getCount();
}
