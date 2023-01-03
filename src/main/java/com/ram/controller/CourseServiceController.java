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

import com.ram.exception.CourseNotfoundException;
import com.ram.model.Course;
import com.ram.service.CourseService;

@RestController
//@CrossOrigin(origins="http://localhost:3001")
@CrossOrigin(origins="*")
public class CourseServiceController
{
	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/courses", method = RequestMethod.POST)
	public ResponseEntity<Object> createCourse(@RequestBody Course course)
	{
		course = courseService.createCourse(course);
		return new ResponseEntity<>("Course is created successfully with id = " +course.getCourse_id(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCourse(@PathVariable("id") int course_id,
			@RequestBody Course course)
	{
		boolean isCourseExist = courseService.isCourseExist(course_id);
		if (isCourseExist)
		{
			course.setCourse_id(course_id);
			courseService.updateCourse(course);
			return new ResponseEntity<>("Course is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new CourseNotfoundException();
		}

	}

	@RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCourse(@PathVariable("id") int course_id)
	{
		boolean isCourseExist = courseService.isCourseExist(course_id);
		if (isCourseExist)
		{
			Course course = courseService.getCourse(course_id);
			return new ResponseEntity<>(course, HttpStatus.OK);
		}
		else
		{
			throw new CourseNotfoundException();
		}

	}

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public ResponseEntity<Object> getCourses()
	{
		List<Course> courseList = courseService.getCourses();
		return new ResponseEntity<>(courseList, HttpStatus.OK);
	}

	@RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCourse(@PathVariable("id") int course_id)
	{
		boolean isCourseExist = courseService.isCourseExist(course_id);
		if (isCourseExist)
		{
			courseService.deleteCourse(course_id);
			return new ResponseEntity<>("Course is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new CourseNotfoundException();
		}

	}

}
