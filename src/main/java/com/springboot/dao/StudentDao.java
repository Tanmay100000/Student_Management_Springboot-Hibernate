package com.springboot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.entitys.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Student s) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(s);

		tr.commit();
		ss.close();

		return "data is inserted...";

	}

	public String deleteData(int stud_id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s=ss.get(Student.class,stud_id);

		ss.remove(s);

		tr.commit();
		ss.close();

		return "data is Delete...";

	}
	
//	public String updateData(int stud_id) {
//		Session ss = factory.openSession();
//		Transaction tr = ss.beginTransaction();
//		ss.get(Student.class,stud_id);
//
//		ss.remove(stud_id);
//
//		tr.commit();
//		ss.close();
//
//		return "data is Delete...";
//
//	}

}
