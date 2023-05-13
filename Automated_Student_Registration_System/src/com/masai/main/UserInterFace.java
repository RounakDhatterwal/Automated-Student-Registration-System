package com.masai.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.masai.Utility.DBUtil;
import com.masai.dao.AdminstratorDao;
import com.masai.dao.AdminstratorDaoImpl;
import com.masai.dao.StudentsDao;
import com.masai.dao.StudentsDaoImpl;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Batch;
import com.masai.model.Consolidate;
import com.masai.model.Course;
import com.masai.model.Student;

// Common Interface for Adminstrator and student

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
		
		String message = "Student not added successfully ❌";
		try {
			message = dao.addStudents(student);
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(message+"✔");
	}
	// -------------------------------------------------------------------------------------

	public static void addCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Course name : ");
		String firstname = sc.next();
		System.out.print("Enter Course fee : ");
		int fee = sc.nextInt();
		System.out.print("Enter Course duration : ");
		int duration = sc.nextInt();
		System.out.print("Enter Course Description : ");
		String description = sc.next();

		AdminstratorDao dao = new AdminstratorDaoImpl();
		
		Course course = new Course();
		course.setName(firstname);
		course.setFee(fee);
		course.setDuration(duration);
		course.setDescription(description);

		String message = "Course has been not added successfully ❌";
		try {
			dao.addnewCourse(course);
			message = "Course has been added successfully ✔";
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
		System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»");
		System.out.print("Enter your choice : ");
		int choice = Integer.parseInt(sc.nextLine());
		AdminstratorDao dao = new AdminstratorDaoImpl();
		String name = null;
		int time = 0;
		int fee = 0;
		if(choice == 1) {
			System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»");
			System.out.print("Enter Course Name you are looking for : ");
			name = sc.nextLine();
			
			try {
				List<Course> list = dao.searchCourseDetails(name,0,0);
				System.out.println(list);
			} catch (CourseException e) {
				System.out.println(e.getMessage());
			}
		}else if(choice == 2) {
			System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»");
			System.out.print("Enter Course Duration you are looking for : ");
			
			time = Integer.parseInt(sc.nextLine());
			System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»");
			
			try {
				dao.searchCourseDetails(null,time,0);
			} catch (CourseException e) {
				System.out.println(e.getMessage());
			}
		}else if(choice == 3) {
			System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»");
			System.out.print("Enter Course Fee to get all course with same fee : ");
			
			fee = Integer.parseInt(sc.nextLine());
			System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»");
			
			try {
				dao.searchCourseDetails(name, time, fee);
				System.out.println("iiii");
			} catch (CourseException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Please Enter Correct Choice ❗");
		}
		
	}
	//-----------------------------------------------------------------------
	
	public static void updateCourseDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Course ID : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Updated Course name");
		String name = sc.nextLine();
		System.out.println("Enter Updated fee");
		int fee = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Updated duration");
		int duration = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Updated description");
		String description = sc.nextLine();
		
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			String message = dao.updateCourseDetails(id, name, fee, duration, description);
			System.out.println(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			UserInterFace.updateCourseDetails();
		}
	}
	//-----------------------------------------------------------------------
//																	4-> Create a Batch under a course
	
	public static void createBatch() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter Batch Start Date (in the format YYYY/MM/DD ): ");
		String startdate = sc.nextLine();
//		SimpleDateFormat sformatter = new SimpleDateFormat("YYYY/MM/DD");
       
        
		System.out.println("Enter Batch End Date (in the format YYYY/MM/DD ): ");
		String enddate = sc.nextLine();
//		SimpleDateFormat eformatter = new SimpleDateFormat("YYYY/MM/DD");
        
        
		System.out.println("Enter Batch capacity : ");
	    int capacity = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Batch course_id : ");
		int course_id = Integer.parseInt(sc.nextLine());
		
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			Batch batch = new Batch();
			batch.setName(name);
			batch.setStartdate((startdate));
			batch.setEnddate((enddate));
			batch.setCapacity(capacity);
			batch.setCourse_id(course_id);
			
			dao.createBatchUnderACoruse(batch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Batch created sucessfully");
	}
	//----------------------------------------------------------------------------
//																	5-> Search information about batches
	
	public static void searchBatch() throws Exception {
		String name = null;
		String startdate = null;
		String enddate = null;

        Scanner sc = new Scanner(System.in);
		System.out.println("1. Search by name");
		System.out.println("2. Search by startdate");
		System.out.println("3. Search by enddate");
		int choice = Integer.parseInt(sc.nextLine());
		if(choice == 1) {
			System.out.println("Enter batch name");
			name = sc.nextLine();
			AdminstratorDao dao = new AdminstratorDaoImpl();
			try {
				List<Batch> list = dao.searchBatch(name, null, null);
				list.forEach(u -> {
					System.out.println(u);
				});
			} catch (BatchException e) {
				System.out.println(e.getMessage());
				UserInterFace.searchBatch();
			}
		}else if(choice == 2) {
			System.out.println("Enter batch startdate (in the format YYYY/MM/DD )");
			String sdate = sc.next();
			SimpleDateFormat sformatter = new SimpleDateFormat("YYYY/MM/DD");
	        startdate = sdate;
			AdminstratorDao dao = new AdminstratorDaoImpl();
			try {
				List<Batch> list = dao.searchBatch(name, sdate, null);
				list.forEach(u -> {
					System.out.println(u);
				});
			} catch (BatchException e) {
				System.out.println(e.getMessage());
				UserInterFace.searchBatch();
			}
		}else if(choice == 3) {
			System.out.println("Enter batch enddate (in the format YYYY/MM/DD )");
	        String edate = sc.next();
	        SimpleDateFormat eformatter = new SimpleDateFormat("YYYY/MM/DD");
	        enddate = (edate);
			AdminstratorDao dao = new AdminstratorDaoImpl();
			try {
				List<Batch> list = dao.searchBatch(name, null, edate);
				list.forEach(u -> {
					System.out.println(u);
				});
			} catch (BatchException e) {
				System.out.println(e.getMessage());
				UserInterFace.searchBatch();
			}
		}else {
			System.out.println("Please Enter Correct Choice");
		}
	}
	
	
	//----------------------------------------------------------------------------
//                                                          	6-> Update details of batch		
	
	public static void updateBatch() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch id : ");
		int id = sc.nextInt();
		System.out.println("Enter Batch name : ");
		String name = sc.next();
		
		System.out.println("Enter Batch Start Date (in the format YYYY/MM/DD ): ");
		String startdate = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate sdate = LocalDate.parse(startdate, formatter);
//		SimpleDateFormat sformatter = new SimpleDateFormat("YYYY/MM/DD");
//        Date sdate = sformatter.parse(startdate);
//        
		System.out.println("Enter Batch End Date (in the format YYYY/MM/DD ): ");
		String enddate = sc.next();
//		SimpleDateFormat eformatter = new SimpleDateFormat("YYYY/MM/DD");
		DateTimeFormatter eformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate edate = LocalDate.parse(enddate, eformatter);
        
		System.out.println("Enter Batch capacity : ");
	    int capacity = sc.nextInt();
		System.out.println("Enter Batch course_id : ");
		int course_id = sc.nextInt();
		
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			Batch batch = new Batch();
			batch.setName(name);
			batch.setStartdate(startdate);
			batch.setEnddate(enddate);
			batch.setCapacity(capacity);
			batch.setCourse_id(course_id);
			
			String m = dao.updateBatch(id, batch.getName(), batch.getStartdate(), batch.getEnddate(), batch.getCapacity(), batch.getCourse_id());
			System.out.println(m);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//----------------------------------------------------------------------------
//	                                                            7-> View student details
	
	public static void viewStudentDetails() {
		System.out.println("Enter Student ID : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			List<Student> list = (dao.viewStudentDetails(id));
			list.forEach(e -> {
				System.out.println(e);
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	//----------------------------------------------------------------------------
//														8-> View the student list of a batch
	
	public static void viewListofBatch() {
		System.out.println("Enter Batch ID : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			List<String> list = dao.studentListofBatch(id);
			list.forEach(o -> {
				System.out.println(o);
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//-------------------------------------------------------------------------------
//													9-> For Consolidated Report
	
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
		AdminstratorDao dao = new AdminstratorDaoImpl();
		try {
			List<Consolidate> list = dao.getReport();
			list.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
//																STUDENTS
	//*************************************************************************************************************************************
	
	public static void updateStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter firstname to update your data");
		String firstname = sc.nextLine();
		System.out.println("Enter lastname to update your data");
		String lastname = sc.nextLine();
		System.out.println("Enter updated address");
		String address = sc.next();
		System.out.println("Enter updated mobile number");
		String mobile_number = sc.next();
		System.out.println("Enter updated email");
		String email = sc.next();
		System.out.println("Enter updated password");
		String password = sc.next();
		
		StudentsDao dao = new StudentsDaoImpl();
		
		try {
			String message = dao.updateStudent(firstname, lastname, address, mobile_number, email, password);
			System.out.println(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//----------------------------------------------------------------------------------------------
	//                                             2. Change password
	
	public static void changePassword() {
		System.out.println("Enter your old password to continue");
		Scanner sc = new Scanner(System.in);
		String pass = sc.next();
		System.out.println("Enter new password");
		String newpass = sc.next();
		StudentsDao dao = new StudentsDaoImpl();
		
		try {
			String message = dao.changePassword(pass,newpass);
			System.out.println(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			StudentUI.studentUI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//---------------------------------------------------------------------------------------
	//											3. All available course list
	
	public static void courseList() {
		StudentsDao dao = new StudentsDaoImpl();
		
		try {
			List<Course> list = dao.available_course_list();
			list.forEach(e -> {
				System.out.println(e);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			StudentUI.studentUI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//---------------------------------------------------------------------------------------
	//											4. All batches

	public static void allBatchList() {
		StudentsDao dao = new StudentsDaoImpl();
		
		try {
			List<Batch> batch = dao.available_batches_list();
			batch.forEach(a -> System.out.println(a));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			StudentUI.studentUI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//---------------------------------------------------------------------------------------
	//											5. Register in a course
	
	public static void registerInCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student_id :");
		int id = sc.nextInt();
		System.out.println("Enter batch_id");
		int batch_id = sc.nextInt();
		
		StudentsDao dao = new StudentsDaoImpl();
		
		try {
			String message = dao.enrollStudentInCourse(id,batch_id);
			System.out.println(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	//---------------------------------------------------------------------------------------
	//											5. delete student account
	
	public static void deleteStudentaccount() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your firstname to delete account");
		String firstname = sc.next();
		
		StudentsDao dao = new StudentsDaoImpl();
		
		try {
			String message = dao.deleteStudentAccount(firstname);
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//=================================================================================================================================
	
	//           Extra Methods
	
	public static boolean validateStudent(String username ,String password) throws StudentException {
		try (Connection con = DBUtil.provideConnection()){
			PreparedStatement ps = con.prepareStatement("select * from student WHERE email = '"+username+"' AND password = '"+password+"' ");
//			ps.setString(2, password);
//			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				UI.student_id = rs.getInt("student_id");
				return true;
				
			}else {
				return false;
			}

		} catch (SQLException e) {
			throw new StudentException();
		}
		
	}
	
	public static String showStudentName(int id) throws StudentException {
		
		String name = "Hello";
		
		try (Connection con = DBUtil.provideConnection()){
			PreparedStatement ps = con.prepareStatement("select firstname from student where student_id = ?");
//			ps.setString(2, password);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString("firstname");
			}

		} catch (SQLException e) {
			throw new StudentException();
		}
		
		return name;
	}
	
	
	
	
}
