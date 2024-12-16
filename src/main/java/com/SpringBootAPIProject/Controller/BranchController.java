package com.SpringBootAPIProject.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.SpringBootAPIProject.Entity.Branch;
import com.SpringBootAPIProject.Entity.Student;
import com.SpringBootAPIProject.Service.BranchService;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class BranchController {
	
	@Autowired
	BranchService branchservice;
	
	@PostMapping("/addbranch")
	public void addBranch(@RequestBody Branch branch) {		
		branchservice.addBranch(branch);
	}
	
	@GetMapping("/getallbrach")
	public Set<Branch> getAllBranch() {
	    return branchservice.getAllBranch(); // This should now return a Set
	}

	
	@GetMapping("/getbranchbyname")
	public List<Branch> getBranchByName(@RequestParam String branchName) {
		return branchservice.getBranchByName(branchName);
	}
	

	@PutMapping("/updates/{branchId}")
	public Branch updateBranch(@RequestBody Branch branch, @PathVariable Integer branchId) {
		return branchservice.updateBranch(branch ,branchId);
		

	}
}
