package com.masai.main;

import java.util.Scanner;

import com.masai.model.Student;

public class UI {

	public static void ui() throws Exception {
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ");										
		System.out.println("! Enter 1 for Login as Adminstrator  ! ");
		System.out.println("! Enter 2 for Login as Student       ! ");
		System.out.println("! Enter 3 for Register as Student    ! ");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ");
		
		Scanner sc = new Scanner(System.in);
		int a = 0;
		try {
			a = Integer.parseInt( sc.nextLine());
		} catch (Exception e) {
			System.out.println("Enter correct option");
		}
		
		
		switch(a) {
		case 1 :
			System.out.println();
			System.out.println("---------------------------");
			System.out.println("| Adminstrator Login Page | ");
			System.out.println("---------------------------");
			System.out.print("Enter Username : ");
			String username = sc.next();
			System.out.print("Enter Password : ");
			String password = sc.next();
			if(username.equals("admin") && password.equals("admin")) {
				System.out.println();
				System.out.println("------------------------");
				System.out.println("| Welcome Adminstrator | ");
				System.out.println("------------------------");	
				
				AdminstratorUI.adminUI();
			}else {
				System.out.println("Please Enter correct credentials");
				UI.ui();
			}
			
			break;
		case 2 : 
			System.out.println();
			System.out.println("----------------------");
			System.out.println("| Student Login Page |");
			System.out.println("----------------------");
			System.out.println("Enter Your Username : ");
			String Student_username = sc.next();
			System.out.println("Enter Your Password : ");
			String Student_password = sc.next();
			if(true) {
				StudentUI.studentUI();
			}
			
			
			break;
		case 3 :
			System.out.println();
			System.out.println("-----------------------------");
			System.out.println("| Student Registration Page |");
			System.out.println("-----------------------------");
			
			UserInterFace.addStudnets();
			
			break;	
		default : 
			System.out.println("Please Enter Correct Option");
			ui();
			
		}
			
	}
	
	public static void main(String[] args) throws Exception {
		ui();
	}

}
