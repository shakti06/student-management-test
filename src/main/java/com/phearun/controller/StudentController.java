package com.phearun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phearun.model.Student;
import com.phearun.service.StudentService;
import com.phearun.utility.Paging;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> findAll(){
		
		List<Student> students = studentService.findAll();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	} 
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAll(Paging paging){
		Map<String, Object> response = new HashMap<>();
		
		List<Student> students = studentService.findAll(paging);
		
		if(!students.isEmpty()){
			response.put("STATUS", true);
			response.put("MESSAGE", "Records Found!");
			response.put("STUDENTS", students);
			response.put("PAGING", paging);
			
		}else{
			response.put("STATUS", false);
			response.put("MESSAGE", "Records Not Found!");
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	} 
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAll(@PathVariable("id") int id){
		Map<String, Object> response = new HashMap<>();
		
		Student student = studentService.findOne(id);

		if(student != null){
			response.put("STATUS", true);
			response.put("MESSAGE", "Record Found!");
			response.put("STUDENT", student);		
			
		}else{
			response.put("STATUS", false);
			response.put("MESSAGE", "Record Not Found!");		
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	} 

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("id") int id){
		Map<String, Object> response = new HashMap<>();
		
		boolean status = studentService.remove(id);

		response.put("STATUS", status);		
		if(status)
			response.put("MESSAGE", "Operation Succeed!");
		else
			response.put("MESSAGE", "Operation Failed!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	} 
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> update(@RequestBody Student student){
		Map<String, Object> response = new HashMap<>();
		
		boolean status = studentService.update(student);
		
		response.put("STATUS", status);
		if(status)
			response.put("MESSAGE", "Operation Succeed!");
		else
			response.put("MESSAGE", "Operation Failed!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	} 
	
}
