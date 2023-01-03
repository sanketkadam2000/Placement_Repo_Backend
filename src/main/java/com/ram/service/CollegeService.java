package com.ram.service;

import java.util.List;

import com.ram.model.College;

public interface CollegeService
{
	public abstract College createCollege(College college);

	public abstract void updateCollege(College college);
	
	public abstract College getCollege(int college_id);
	
	public abstract List<College> getColleges();
	
	public abstract void deleteCollege(int college_id);
	
	public abstract boolean isCollegeExist(int college_id);
	
	public abstract int getCount();
}
