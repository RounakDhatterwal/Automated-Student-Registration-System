package com.masai.main;

import java.util.Scanner;

public class UI {

	public static void main(String[] args) {
		System.out.println("Enter 1 for Login as Adminstrator");
		System.out.println("Enter 2 for Login as Student");
		System.out.println("Enter 3 for Register as Student");
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		if(a==1) {
			System.out.println("Adminstrator Login Page");
			System.out.print("Enter Admin Username : ");
			String username = sc.next();
			System.out.println("Enter Admin Password : ");
			String password = sc.next();
			
			
			
		}else if(a==2) {
			System.out.println("Student Login page");
			System.out.println("Enter Your Username : ");
			String username = sc.next();
			System.out.println("Enter Your Password : ");
			String password = sc.next();
			
			
			
			
		}else if(a==3) {
			System.out.println("Student Registration Page");
			System.out.println("Enter Student Firstname");
			System.out.println("Enter Student Lastname");
			System.out.println("Student Registration Page");
			System.out.println("Student Registration Page");
		}else {
			System.out.println("Please Enter Correct Option");
		}
	}

}
