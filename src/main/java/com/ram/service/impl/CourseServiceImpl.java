package com.ram.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.Course;
import com.ram.repository.CourseRepository;
import com.ram.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService
{

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course createCourse(Course course)
	{
		return courseRepository.save(course);
	}

	@Override
	public void updateCourse(Course course)
	{
		courseRepository.save(course);
	}
	
	@Override
	public Course getCourse(int id)
	{
		Optional<Course> optional = courseRepository.findById(id);
		Course course = optional.get();
		return course;
	}

	@Override
	public List<Course> getCourses()
	{
		return (List<Course>)courseRepository.findAll();
	}
	
	@Override
	public int getCount() {
		return (int) courseRepository.count();
	}

	@Override
	public void deleteCourse(int id)
	{
		courseRepository.deleteById(id);
	}

	@Override
	public boolean isCourseExist(int id)
	{
		return courseRepository.existsById(id);
	}
}
