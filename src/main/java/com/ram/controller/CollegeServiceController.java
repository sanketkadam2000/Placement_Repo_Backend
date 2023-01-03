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

import com.ram.exception.CollegeNotfoundException;
import com.ram.model.College;
import com.ram.service.CollegeService;

@RestController
//@CrossOrigin(origins="http://localhost:3001")
@CrossOrigin(origins="*")
public class CollegeServiceController
{
	@Autowired
	private CollegeService collegeService;

	@RequestMapping(value = "/colleges", method = RequestMethod.POST)
	public ResponseEntity<Object> createCollege(@RequestBody College college)
	{
		college = collegeService.createCollege(college);
		return new ResponseEntity<>("College is created successfully with id = " +college.getCollege_id(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/colleges/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCollege(@PathVariable("id") int college_id,
			@RequestBody College college)
	{
		boolean isCollegeExist = collegeService.isCollegeExist(college_id);
		if (isCollegeExist)
		{
			college.setCollege_id(college_id);
			collegeService.updateCollege(college);
			return new ResponseEntity<>("College is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new CollegeNotfoundException();
		}

	}

	@RequestMapping(value = "/colleges/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCollege(@PathVariable("id") int college_id)
	{
		boolean isCollegeExist = collegeService.isCollegeExist(college_id);
		if (isCollegeExist)
		{
			College college = collegeService.getCollege(college_id);
			return new ResponseEntity<>(college, HttpStatus.OK);
		}
		else
		{
			throw new CollegeNotfoundException();
		}

	}

	@RequestMapping(value = "/colleges", method = RequestMethod.GET)
	public ResponseEntity<Object> getColleges()
	{
		List<College> collegeList = collegeService.getColleges();
		return new ResponseEntity<>(collegeList, HttpStatus.OK);
	}

	@RequestMapping(value = "/colleges/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCollege(@PathVariable("id") int college_id)
	{
		boolean isCollegeExist = collegeService.isCollegeExist(college_id);
		if (isCollegeExist)
		{
			collegeService.deleteCollege(college_id);
			return new ResponseEntity<>("College is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new CollegeNotfoundException();
		}

	}

}
