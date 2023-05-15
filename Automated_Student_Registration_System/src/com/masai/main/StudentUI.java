package com.masai.main;

import java.util.Scanner;

// // user Interface for student

public class StudentUI {
	public static void studentUI() throws Exception {
		System.out.println("---------------------->");
		System.out.println("Welcome -  ✨ " + UserInterFace.showStudentName(UI.student_id) +" ✨" );
		System.out.println("---------------------->");
		System.out.println("1. Update personal details");
		System.out.println("2. Change password");
		System.out.println("3. All available course list");
		System.out.println("4. All batches ");
		System.out.println("5. Register in a course");
		System.out.println("6. Logout");
		System.out.println("7. Delete your account");
		System.out.println("〰〰〰〰〰〰〰〰〰〰〰〰〰");
		System.out.print("Enter your choice : ");
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		System.out.println("〰〰〰〰〰〰〰〰〰〰〰〰〰");
		switch(a) {
		case 1 :
			UserInterFace.updateStudent();
			break;
		case 2 :
			UserInterFace.changePassword();
			break;
		case 3 :
			UserInterFace.courseList();
			break;
		case 4 :
			UserInterFace.allBatchList();
			StudentUI.studentUI();
			break;
		case 5 :
			UserInterFace.registerInCourse();
			StudentUI.studentUI();
			break;
		case 6 :
			UI.ui();
			break;
		case 7 :
			UserInterFace.deleteStudentaccount();
			UI.ui();
			break;
		default : System.out.println("Enter correct option");
		
		}
	}
}
