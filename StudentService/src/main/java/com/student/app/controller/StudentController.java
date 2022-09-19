package com.student.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import com.student.app.entity.Student;

@RestController
public class StudentController {
	
	private static Map<String,List<Student>> schoolDB = new HashMap<String,List<Student>>();
	
	static {
		List<Student> lst = new ArrayList<Student>();
		Student std = new Student("Nishant","class 2");
		lst.add(std);
		std = new Student("Vishal", "class 3");
		lst.add(std);
		
		schoolDB.put("school1", lst);
		
		lst = new ArrayList<Student>();
		std = new Student("Sara","class 12");
		lst.add(std);
		std = new Student("Resh", "class 12");
		lst.add(std);
		
		schoolDB.put("school2", lst);
		
	}
	
	@GetMapping("/getStudentDetailsForSchool/{schoolName}")
	public List<Student> getStudents(@PathVariable String schoolName){
		System.out.println("Getting student details of : "+schoolName);
		List<Student> studentlist = schoolDB.get(schoolName);
		if(studentlist == null) {
			studentlist = new ArrayList<Student>();
			Student std = new Student("Not found 404","NA");
			studentlist.add(std);
		}
		return studentlist;
	}
	
	

}
