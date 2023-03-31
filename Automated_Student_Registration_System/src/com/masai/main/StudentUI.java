package com.masai.main;

import java.util.Scanner;

public class StudentUI {
	public static void studentUI() {
		System.out.println("1. Update personal details");
		System.out.println("2. Change password");
		System.out.println("3. All available course list");
		System.out.println("4. All batches ");
		System.out.println("5. Register in a course");
		System.out.println("6. Logout");
		System.out.println("7. Delete your account");
		
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		
		switch(a) {
		case 1 :
			
			
			break;
		case 2 :
			
			
			break;
		case 3 :
			
			
			break;
		case 4 :
			
			
			break;
		case 5 :
			
			
			break;
		case 6 :
			
			
			break;
		case 7 :
			
			
			break;
		default : System.out.println("Enter correct option");
		
		}
	}
}
