package com.SpringBootAPIProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootAPIProject.Entity.Branch;
import com.SpringBootAPIProject.Entity.College;
import com.SpringBootAPIProject.Repo.CollegeRepo;

@Service
public class CollegeService {
	@Autowired
	CollegeRepo collegerepo;

	

	public College addCollege(College college) {
		 if (college.getBranch() != null) 
		        
		        for (Branch branch : college.getBranch()) {
		            branch.setCollege(college); // Set the college for each branch
		        }else {
		        	return collegerepo.save(college);
				}
		    
		    return collegerepo.save(college);
		}
	}
 