package com.springboot.service;

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

}
