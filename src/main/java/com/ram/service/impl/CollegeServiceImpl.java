package com.ram.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.College;
import com.ram.repository.CollegeRepository;
import com.ram.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService
{

	@Autowired
	private CollegeRepository collegeRepository;

	@Override
	public College createCollege(College college) {
		
		return collegeRepository.save(college);
	}

	@Override
	public void updateCollege(College college) {
		
		collegeRepository.save(college);

	}

	@Override
	public College getCollege(int college_id) {
		Optional<College> optional = collegeRepository.findById(college_id);
		College college = optional.get();
		return college;
	}

	@Override
	public List<College> getColleges() {
		
		return (List<College>)collegeRepository.findAll();
	}

	@Override
	public void deleteCollege(int college_id) {
	
		collegeRepository.deleteById(college_id);
	}

	@Override
	public boolean isCollegeExist(int college_id) {
		
		return collegeRepository.existsById(college_id);
	}
	
	@Override
	public int getCount() {
		return (int) collegeRepository.count();
	}
}
