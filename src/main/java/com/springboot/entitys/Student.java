package com.springboot.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stud_id;
	private String name;
	private int age;
	private String city;
	
	
	
	
	public Student() {
		
	}




	public Student(int stud_id, String name, int age, String city) {
		super();
		this.stud_id = stud_id;
		this.name = name;
		this.age = age;
		this.city = city;
	}




	public int getStud_id() {
		return stud_id;
	}




	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
	
	
	

}
