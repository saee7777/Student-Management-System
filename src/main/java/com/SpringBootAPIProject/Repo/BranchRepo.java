package com.SpringBootAPIProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringBootAPIProject.Entity.Branch;


import java.util.List;


@Repository
public interface BranchRepo extends JpaRepository<Branch, Integer> {
	@Query(value = "SELECT * FROM branch WHERE branch_name = :branchName", nativeQuery = true)
	List<Branch> findByBranchName(@Param("branchName") String branchName);

}

