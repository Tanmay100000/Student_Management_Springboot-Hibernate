package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entitys.Student;
import com.springboot.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public String insertData(@RequestBody Student s) {
		String msg=service.insertData(s);
		return msg;
	}
	
	@DeleteMapping("/delete/{stud_id}")
	public String deletetData(@PathVariable int stud_id) {
		String msg=service.deletetData(stud_id);
		return msg;
	}

	@PutMapping("/update/{stud_id}")
	public String UpdateData(@RequestBody Student s,@PathVariable int stud_id) {
		String msg= service.UpdateData(s, stud_id);
		return msg;
	}
	
	@GetMapping("/getsingleRecord/{stud_id}")
	public Student updateData(@PathVariable int stud_id) {
		Student s1 = service.getSingleData(stud_id);
		return s1;

	}
	
	@GetMapping("/getAllRecord")
	 public List<Student> getAllRecord(){
		 List<Student> list= service.getAllRecords();
		 return list;
	 }
}
