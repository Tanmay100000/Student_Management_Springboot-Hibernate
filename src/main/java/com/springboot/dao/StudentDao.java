package com.springboot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springboot.controller.StudentController;
import com.springboot.entitys.Student;

import jakarta.persistence.Query;

@Repository
public class StudentDao {

   

	@Autowired
	SessionFactory factory;

   

	public String insertData(Student s) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

//		ss.persist(s);
		
		String hqlQuery3= "insert into Student(name,age,city) values(:name,:age,:city)";
		MutationQuery query2=ss.createMutationQuery(hqlQuery3);
		query2.setParameter("name", s.getName());
		query2.setParameter("age", s.getAge());
		query2.setParameter("city", s.getCity());
		query2.executeUpdate();
		

		tr.commit();
		ss.close();

		return "data is inserted...";
		
		

	}

	public String deleteData(int stud_id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s=ss.get(Student.class,stud_id);

//		ss.remove(s);
		String hqlQuery="delete from Student where stud_id=:stud_id";
		MutationQuery query=ss.createMutationQuery(hqlQuery);
		query.setParameter("stud_id", stud_id);
		query.executeUpdate();

		tr.commit();
		ss.close();

		return "data is Delete...";

	}
	
	public String updateData(Student s,int stud_id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s1 =ss.get(Student.class,stud_id);
		
		s1.setAge(s.getAge());
        s1.setName(s.getName());
        s1.setCity(s.getCity());
        
        
        
//		ss.merge(s1);

        String hqlQuery="update Student set name=:name where stud_id=:stud_id";
        MutationQuery query=ss.createMutationQuery(hqlQuery);
        query.setParameter("stud_id", stud_id);
        query.setParameter("name", s.getName());
       
        query.executeUpdate();        
        
		tr.commit();
		ss.close();

		return "data is Update...";

	}
	
	
	public Student getSingleRecord(int stud_id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlQuery = "from Student where stud_id=:stud_id";
		Query query = ss.createQuery(hqlQuery, Student.class);
		query.setParameter("stud_id", stud_id);
		Student s1 = (Student) query.getSingleResult();
		
//		Student s1 = ss.get(Student.class, stud_id);
		
		tr.commit();
		ss.close();

		return s1;
	}
	
	public List<Student> GetAllData(){
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		String hqlQuery1 = "from Student ";
		Query query1 = ss.createQuery(hqlQuery1, Student.class);
		
		List<Student> list= query1.getResultList();		
		
		tr.commit();
		ss.close();
		
		return list;
		
	}

}
