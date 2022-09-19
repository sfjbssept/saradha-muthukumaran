package com.school.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/schooldetail")
public class SchoolServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{schoolName}")
	public String getStudents(@PathVariable String schoolName) {
		System.out.println("Getting school details for : "+schoolName);
		String requestURL = "http://localhost:9091/getStudentDetailsForSchool/"+schoolName;
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<String>(header);
		
		ResponseEntity<String> response = restTemplate.exchange(requestURL, HttpMethod.GET, httpEntity, String.class);
		String student = response.getBody();
		
		System.out.println("Response received is "+student);
		
		return "School name - "+schoolName+ "\n Student Details: "+student;
		
	}

}
