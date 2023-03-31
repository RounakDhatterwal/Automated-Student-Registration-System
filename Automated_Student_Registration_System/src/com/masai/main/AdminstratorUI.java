package com.masai.main;

import java.net.UnknownServiceException;
import java.util.Scanner;

public class AdminstratorUI {
	public static void adminUI() throws Exception {
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
		
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		
		switch(a) {
		case 1 :
			UserInterFace.addCourse();
			break;
		case 2 :
			UserInterFace.searchCourse();
			break;
		case 3 :
			UserInterFace.updateCourseDetails();
			break;
		case 4 :
			UserInterFace.createBatch();
			break;
		case 5 :
			UserInterFace.searchBatch();
			break;
		case 6 :
			UserInterFace.updateBatch();
			break;
		case 7 :
			UserInterFace.viewStudentDetails();
			break;
		case 8 :
			UserInterFace.viewListofBatch();
			break;
		case 9 :
			UserInterFace.consolidatedReport();
			break;
		case 0 :
			AdminstratorUI.adminUI();
			break;
		default : System.out.println("Please Enter Correct option");	
		}
	}
}
