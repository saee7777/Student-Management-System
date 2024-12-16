package com.SpringBootAPIProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootAPIProject.Entity.Branch;
import com.SpringBootAPIProject.Entity.College;
import com.SpringBootAPIProject.Service.CollegeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CollegeController {
	
	@Autowired
	CollegeService collegeservice;
	
	@PostMapping("/addcollege")
	public College addCollege(@RequestBody College college) {	
		return collegeservice.addCollege(college);
	}

}
