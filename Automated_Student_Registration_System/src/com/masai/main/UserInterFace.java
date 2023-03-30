package com.masai.main;

import java.util.Scanner;

import com.masai.dao.StudentsDao;
import com.masai.dao.StudentsDaoImpl;
import com.masai.exception.StudentException;
import com.masai.model.Student;

public class UserInterFace {

	public static void addStudnets(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student Firstname : ");
		String firstname = sc.next();
		System.out.print("Enter Student Lastname : ");
		String lastname = sc.next();
		System.out.print("Enter Student Address : ");
		String address = sc.next();
		System.out.print("Enter Student Mobile Number : ");
		String mobile_number = sc.next();
		System.out.print("Enter Student Email : ");
		String email = sc.next();
		System.out.print("Enter Student Password : ");
		String password = sc.next();
		
		StudentsDao dao = new StudentsDaoImpl();
		
		Student student = new Student(firstname, lastname, address, mobile_number, email, password);
		
		String message = null;
		try {
			message = dao.addStudents(student);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(message);
	}
	
	
	public static void main(String[] args) {
		
	}

}
