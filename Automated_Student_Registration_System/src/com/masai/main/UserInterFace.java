package com.masai.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.masai.dao.AdminstratorDao;
import com.masai.dao.AdminstratorDaoImpl;
import com.masai.dao.StudentsDao;
import com.masai.dao.StudentsDaoImpl;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.Student;

public class UserInterFace {

	
//	                                                               ADMINSTRATOR
	//----------------------------------------------------------------------------------------------------------------
	
	public static void addStudnets() {		
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
	// -------------------------------------------------------------------------------------

	public static void addCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Course name : ");
		String firstname = sc.next();
		System.out.print("Enter Course fee : ");
		int fee = Integer.parseInt(sc.nextLine());
		System.out.print("Enter Course duration : ");
		int duration = Integer.parseInt(sc.nextLine());
		System.out.print("Enter Course Description : ");
		String description = sc.next();

		AdminstratorDao dao = new AdminstratorDaoImpl();
		
		Course course = new Course();
		course.setName(firstname);
		course.setFee(fee);
		course.setDuration(duration);
		course.setDescription(description);

		String message = null;
		try {
			message = dao.addnewCourse(course);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(message);
	}
	// -------------------------------------------------------------------------------------
	
	public static void searchCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Search by name");
		System.out.println("2. Search by course ID");
		System.out.println("3. Search by course Fee");
		int choice = Integer.parseInt(sc.nextLine());
		String name = null;
		int id = -1;
		int fee = -1;
		if(choice == 1) {
			System.out.print("Enter Course Name you are looking for : ");
			name = sc.nextLine();
			AdminstratorDao dao = new AdminstratorDaoImpl();
			try {
				dao.searchCourseDetails(name,id,fee);
			} catch (CourseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(choice == 2) {
			System.out.print("Enter Course ID you are looking for : ");
			id = Integer.parseInt(sc.nextLine());
			AdminstratorDao dao = new AdminstratorDaoImpl();
			try {
				dao.searchCourseDetails(name,id,fee);
			} catch (CourseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(choice == 3) {
			System.out.print("Enter Course Fee to get all course with same fee : ");
			fee = Integer.parseInt(sc.nextLine());
			AdminstratorDao dao = new AdminstratorDaoImpl();
			try {
				dao.searchCourseDetails(name,id,fee);
			} catch (CourseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Please Enter Correct Choice");
		}
		
	}
	//-----------------------------------------------------------------------
	
	public static void updateCourseDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Course ID : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Updated Course name");
		String name = sc.next();
		System.out.println("Enter Updated Course name");
		int fee = Integer.parseInt(sc.nextLine()) ;
		System.out.println("Enter Updated Course name");
		int duration = Integer.parseInt(sc.nextLine()) ;
		System.out.println("Enter Updated Course name");
		String description = sc.nextLine();
		
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			dao.updateCourseDetails(id, name, fee, duration, description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//-----------------------------------------------------------------------
//																	4-> Create a Batch under a course
	
	public static void createBatch() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter Batch Start Date (in the format YYYY/MM/DD ): ");
		String startdate = sc.next();
		SimpleDateFormat sformatter = new SimpleDateFormat("YYYY/MM/DD");
        Date sdate = sformatter.parse(startdate);
        
		System.out.println("Enter Batch End Date (in the format YYYY/MM/DD ): ");
		String enddate = sc.nextLine();
		SimpleDateFormat eformatter = new SimpleDateFormat("YYYY/MM/DD");
        Date edate = eformatter.parse(enddate);
        
		System.out.println("Enter Batch capacity : ");
	    String capacity = sc.next();
		System.out.println("Enter Batch course_id : ");
		int course_id = Integer.parseInt(sc.nextLine());
		
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			Batch batch = new Batch();
			batch.setName(name);
			batch.setStartdate(sdate);
			batch.setEnddate(edate);
			batch.setCapacity(capacity);
			batch.setCourse_id(course_id);
			
			dao.createBatchUnderACoruse(batch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//----------------------------------------------------------------------------
//																	5-> Search information about batches
	
	public static void searchBatch() throws Exception {
		String name = null;
		Date startdate = null;
		Date enddate = null;

        Scanner sc = new Scanner(System.in);
		System.out.println("1. Search by name");
		System.out.println("2. Search by course ID");
		System.out.println("3. Search by course Fee");
		int choice = Integer.parseInt(sc.nextLine());
		if(choice == 1) {
			System.out.println("Enter batch name");
			name = sc.nextLine();
			AdminstratorDao dao = new AdminstratorDaoImpl();
			try {
				dao.searchBatch(name, null, null);
			} catch (BatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(choice == 2) {
			System.out.println("Enter batch startdate (in the format YYYY/MM/DD )");
			String sdate = sc.next();
			SimpleDateFormat sformatter = new SimpleDateFormat("YYYY/MM/DD");
	        startdate = sformatter.parse(sdate);
			AdminstratorDao dao = new AdminstratorDaoImpl();
			try {
				dao.searchBatch(name, sdate, null);
			} catch (BatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(choice == 3) {
			System.out.println("Enter batch enddate (in the format YYYY/MM/DD )");
	        String edate = sc.next();
	        SimpleDateFormat eformatter = new SimpleDateFormat("YYYY/MM/DD");
	        enddate = eformatter.parse(edate);
			AdminstratorDao dao = new AdminstratorDaoImpl();
			try {
				dao.searchBatch(name, null, edate);
			} catch (BatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Please Enter Correct Choice");
		}
	}
	
	
	//----------------------------------------------------------------------------
//                                                               	6-> Update details of batch		
	
	public static void updateBatch() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch name : ");
		int id = sc.nextInt();
		System.out.println("Enter Batch name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter Batch Start Date (in the format YYYY/MM/DD ): ");
		String startdate = sc.next();
		SimpleDateFormat sformatter = new SimpleDateFormat("YYYY/MM/DD");
        Date sdate = sformatter.parse(startdate);
        
		System.out.println("Enter Batch End Date (in the format YYYY/MM/DD ): ");
		String enddate = sc.nextLine();
		SimpleDateFormat eformatter = new SimpleDateFormat("YYYY/MM/DD");
        Date edate = eformatter.parse(enddate);
        
		System.out.println("Enter Batch capacity : ");
	    String capacity = sc.next();
		System.out.println("Enter Batch course_id : ");
		int course_id = Integer.parseInt(sc.nextLine());
		
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			Batch batch = new Batch();
			batch.setName(name);
			batch.setStartdate(sdate);
			batch.setEnddate(edate);
			batch.setCapacity(capacity);
			batch.setCourse_id(course_id);
			
//			dao.updateBatch(id, name, sdate, edate, capacity, course_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//----------------------------------------------------------------------------
//	                                                                              7-> View student details
	
	public static void viewStudentDetails() {
		System.out.println("Enter Student ID : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			dao.viewStudentDetails(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	//----------------------------------------------------------------------------
//																			8-> View the student list of a batch
	
	public static void viewListofBatch() {
		System.out.println("Enter Batch ID : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			dao.studentListofBatch(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//-------------------------------------------------------------------------------
//																		9-> For Consolidated Report
	
//	public static void consolidatedReport() {
//		System.out.println("Enter Batch ID : ");
//		Scanner sc = new Scanner(System.in);
//		int id = sc.nextInt();
//		AdminstratorDao dao = new AdminstratorDaoImpl();
//		try {
//			dao.studentListofBatch(id);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	public static void consolidatedReport() {
		// TODO Auto-generated method stub
		
	}
	
//																STUDENTS
	//*************************************************************************************************************************************
	
//	public static void 
	
}
