package com.SpringBootAPIProject.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringBootAPIProject.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query(value = "SELECT * FROM student WHERE city = :city", nativeQuery = true)  
	          //nativeQuery use to cheack Datbase not only entity/table
	         //@Param is used to bind method parameters to a query
	List<Student> findByCity(@Param("city") String city);
	
	@Query(value="SELECT * FROM student WHERE name=:name" , nativeQuery = true)
	List<Student>findByName(@Param("name") String name);

}



