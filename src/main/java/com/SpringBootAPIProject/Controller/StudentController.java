package com.SpringBootAPIProject.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBootAPIProject.Entity.Student;
import com.SpringBootAPIProject.Service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	
	
	//Add Students
	
	@PostMapping("/addstudent")
	public String addStudents(@RequestBody Student student) {
		studentservice.addStudent(student);
		 return "Student Added";
	}	
	
	//Get All Students
	
	@GetMapping("/getall")
	public List<Student> getAllStudents() {
		return studentservice.getAllStudents();
	}
	 
	//Get Student By ID
	
    @GetMapping("/student")
    public Student getStudentById(@RequestParam Integer id) {       //give values in param in postman key and value
    	return studentservice.getStudentById(id);
    }
    
    //Update Students
    
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable Integer id) {
		return studentservice.updateEmployee(student, id);
		
		//RequestBody is used to passed object 
	}
	
	//Delete students
	
	@DeleteMapping("delete/{id}")
	  public ResponseEntity<?>deleteStudent(@PathVariable Integer id){
		  return new ResponseEntity<>(studentservice.deleteStudent(id),HttpStatus.OK);
	  }

    @GetMapping("/getbycity")
    public List<Student> getByCity(@RequestParam String city) {
        return studentservice.getByCity(city);
        
        //RequestParam is used to passed perticular field or column 
    }
     
   @GetMapping("/getbyname")
   public List<Student> getByName(@RequestParam String name){
	   return studentservice.getByName(name);
   }
    
}


    


	
	



