package com.SpringBootAPIProject.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootAPIProject.Entity.Branch;
import com.SpringBootAPIProject.Entity.College;
import com.SpringBootAPIProject.Entity.Student;
import com.SpringBootAPIProject.Repo.BranchRepo;
import com.SpringBootAPIProject.Repo.StudentRepo;

@Service
public class BranchService {
	
	@Autowired
	BranchRepo branchrepo;
	
	@Autowired
	StudentRepo studentrepo;
	

	public Branch addBranch(Branch branch) {
	    // Check if the branch exists
	    if (branch.getCollege() != null) {
	        // Check if the branch is already persisted
	        if (branch.getCollege() == null) {
	            return branchrepo.save(branch);
 
	        }
	    }
		return branchrepo.save(branch);

	}


	public Set<Branch> getAllBranch() {
	    List<Branch> branchList = branchrepo.findAll(); // Assuming findAll returns a List
	    return new HashSet<>(branchList); // Convert List to Set
	}




	public Branch updateBranch(Branch branch, Integer branchId) {
		Branch bran =branchrepo.findById(branchId).get();
		if(bran==null) {
			return null;	
		}
		bran.setBranchId(bran.getBranchId());
		bran.setBranchName(bran.getBranchName());
		return branchrepo.save(branch);
	}


	public List<Branch> getBranchByName(String branchName) {
		return branchrepo.findByBranchName(branchName);
	}


}
