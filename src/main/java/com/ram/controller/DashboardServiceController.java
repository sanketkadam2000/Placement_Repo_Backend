package com.ram.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ram.model.Dashboard;

import com.ram.service.AdminService;
import com.ram.service.CertificateService;
import com.ram.service.CollegeService;
import com.ram.service.PlacementService;
import com.ram.service.StudentService;
import com.ram.service.UserService;


@RestController
public class DashboardServiceController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private CertificateService certificateService;
	@Autowired
	private CollegeService collegeService;
	@Autowired
	private PlacementService placementService;
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudents()
	{
		List<Dashboard> dashboardList=new ArrayList<Dashboard>();
		List<String> servicesNameList=new ArrayList<String>(Arrays.asList("Student","Admin","Certificate","College","Placement","User"));
		for(int i=0; i < servicesNameList.size(); i++)
		{
		Dashboard data=new Dashboard();
		data.setDashboard_id(i+1);
		data.setName((String)servicesNameList.get(i).toString());
		switch((String)servicesNameList.get(i).toString()) {
		case "Student": 
			data.setCount(studentService.getCount());
			break;
		case "Admin": 
			data.setCount(adminService.getCount());
			break;
		case "Certificate":
			data.setCount(certificateService.getCount());
			break;
		case "College":
			data.setCount(collegeService.getCount());
			break;
		case "Placement":
			data.setCount(placementService.getCount());
			break;
		case "User":
			data.setCount(userService.getCount());
			break;
		
		}
		dashboardList.add(data);
		}
		return new ResponseEntity<>(dashboardList, HttpStatus.OK);
	}


}
