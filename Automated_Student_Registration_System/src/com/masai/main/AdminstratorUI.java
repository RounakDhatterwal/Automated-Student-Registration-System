package com.masai.main;

import java.net.UnknownServiceException;
import java.util.Scanner;

public class AdminstratorUI {
	public static void adminUI() throws Exception {
		System.out.println("💨💨💨💨💨💨💨💨💨💨💨💨💨💨");
		System.out.println("1-> Add New Courses");
		System.out.println("2-> Search for information about courses");
		System.out.println("3-> Update details of course");
		System.out.println("4-> Create a Batch under a course");
		System.out.println("5-> Search information about batches");
		System.out.println("6-> Update details of batch");
		System.out.println("7-> View student details");
		System.out.println("8-> View the student list of a batch");
		System.out.println("9-> For Consolidated Report");
		System.out.println("0-> Logout his account");
		System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»");
		System.out.print("Enter your choice : ");
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»");
		
		switch(a) {
		case 1 :
			UserInterFace.addCourse();
			AdminstratorUI.adminUI();
			break;
		case 2 :
			UserInterFace.searchCourse();
			AdminstratorUI.adminUI();
			break;
		case 3 :
			UserInterFace.updateCourseDetails();
			AdminstratorUI.adminUI();
			break;
		case 4 :
			UserInterFace.createBatch();
			AdminstratorUI.adminUI();
			break;
		case 5 :
			UserInterFace.searchBatch();
			AdminstratorUI.adminUI();
			break;
		case 6 :
			UserInterFace.updateBatch();
			AdminstratorUI.adminUI();
			break;
		case 7 :
			UserInterFace.viewStudentDetails();
			AdminstratorUI.adminUI();
			break;
		case 8 :
			UserInterFace.viewListofBatch();
			AdminstratorUI.adminUI();
			break;
		case 9 :
			UserInterFace.consolidatedReport();
			AdminstratorUI.adminUI();
			break;
		case 0 :
			UI.ui();
			break;
		default : System.out.println("Please Enter Correct option");	
		}
	}
}
