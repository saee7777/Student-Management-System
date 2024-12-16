package com.SpringBootAPIProject.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootAPIProject.Entity.Branch;
import com.SpringBootAPIProject.Entity.College;
import com.SpringBootAPIProject.Entity.Student;
import com.SpringBootAPIProject.Repo.BranchRepo;
import com.SpringBootAPIProject.Repo.StudentRepo;

@Service
public class StudentService{
    
	@Autowired
	 StudentRepo studentrepo;
	
	@Autowired
	BranchRepo branchrepo;
 
	public Student addStudent(Student student) {
//	    // Check if the branch exists
//	    if (student.getBranch() != null) {
//	        // Check if the branch is already persisted
//	        if (student.getBranch() == null) {
//	            branchrepo.save(student.getBranch());  // Save branch if it is new
//	        }
//	    }
	    return studentrepo.save(student);  // Save the student
	}
			
	
	public List<Student> getAllStudents() {
		return studentrepo.findAll();
	}
	
	public Student getStudentById(Integer id) {  
		Student student =studentrepo.findById(id).orElse(null);
   	if(student==null) {
   		System.out.println("Student with ID " + id + " not found");
   	}
	    return student; 
		}	



	public Student updateEmployee(Student student, Integer id) {
		Student stu=studentrepo.findById(id).get();
		if(stu==null) {
			return null;
		}
 		stu.setName(student.getName());
		stu.setCity(student.getCity());
		stu.setAge(student.getAge());
		return studentrepo.save(stu);
	
}

   	public String deleteStudent(Integer id) {
		Student student = studentrepo.findById(id).get();
		if(student!=null) {
			studentrepo.delete(student);
			return "Student deleted successfully";
		}else {
			return "student not found";
		}
		
		
   	}

	public List<Student> getByCity(String city) {
		return studentrepo.findByCity(city);
	}

	public List<Student> getByName(String name) {
		return studentrepo.findByName(name);
	}
}

	


		


