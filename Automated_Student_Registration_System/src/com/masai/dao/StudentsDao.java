package com.masai.dao;

import java.util.Map;

import com.masai.model.Student;

public interface StudentsDao {
	
	public String addStudents(Student student);
	
	public String signIn(String username, String password);
	
	public Map<String , Integer> updatePersonalDetails(String username, String password);
	
	
}
