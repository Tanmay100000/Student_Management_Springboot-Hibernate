package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.StudentDao;
import com.springboot.entitys.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public String insertData(Student s) {
		String msg = dao.insertData(s);

		return msg;

	}

	public String deletetData(int stud_id) {
		String msg=dao.deleteData(stud_id);
		return msg;
	}
	
	public String UpdateData(Student s,int stud_id) {
		String msg=dao.updateData(s, stud_id);
		return msg;
				
	}
	
	public Student getSingleData(int stud_id) {
		Student s1 = dao.getSingleRecord(stud_id);
		return s1;
	}
	
	public List<Student> getAllRecords(){
		List<Student> list= dao.GetAllData();
		return list;
	}

}
