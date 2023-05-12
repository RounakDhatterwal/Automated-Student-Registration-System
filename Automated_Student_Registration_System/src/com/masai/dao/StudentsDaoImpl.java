package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.Utility.DBUtil;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.Student;

public class StudentsDaoImpl implements StudentsDao{

	// add students 
	
	@Override
	public String addStudents(Student student) throws StudentException {
		String message = "Student data not entered correctly";
		
		try (Connection con =DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into student(firstname,lastname,address, mobile_number, email, password) values (?,?,?,?,?,?)");
			ps.setString(1, student.getFirstname());
			ps.setString(2, student.getLastname());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getMobile_number());
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getPassword());
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Student Added Sucessfully ✔";
			}
		} catch (SQLException e) {
			throw new StudentException(message);
		}

		return message;
	}
	
	// update student details this will work when we have signed in as a student
	
	@Override
	public String updateStudent(String firstname, String lastname, String address, String mobile_number, String email,
			String password) {
		String message = "Data not updated sucessfully";
		Student student = new Student();
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setAddress(address);
		student.setMobile_number(mobile_number);
		student.setEmail(email);
		student.setPassword(password);
		
		try (Connection con =DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("update student set firstname = ? , lastname = ? , address = ? , mobile_number = ? , email = ? , password = ? WHERE firstname = ? AND lastname = ?");
			ps.setString(1, student.getFirstname());
			ps.setString(2, student.getLastname());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getMobile_number());
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getPassword());
			ps.setString(7, student.getFirstname());
			ps.setString(8, student.getLastname());
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Student Updated Sucessfully";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return message;
	}
	
	// student signin it needs student username and password and password must be same as student has set during registration 

	@Override
	public String signIn(String username, String password) throws StudentException {
		String message = "Wrong User Credentials";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps =  con.prepareStatement("select * from student WHERE email = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				message = "Signed in sucessfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException();
		}
		
		
		return message;
	}
	
	// it updates password of student and it requires student previous password and new password to update
	
	@Override
	public String changePassword(String password, String newpassword) {
		String message  = "Password not updated sucessfully";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("update student set password = ? WHERE password  = ? " );
			ps.setString(1, newpassword);
			ps.setString(2, password);
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Password updated sucessfully";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
		
	}
	
	// this will all available course list 

	@Override
	public List<Course> available_course_list() throws CourseException {
		List<Course> list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			PreparedStatement ps = con.prepareStatement("select * from course");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Course(rs.getString("course_name"), rs.getInt("course_fee"), rs.getInt("course_duration"), rs.getString("course_description")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException();
		}
		
		return list;
	}
	
	// this will give all running batches in current time

	@Override
	public List<Batch> available_batches_list() throws BatchException {
		List<Batch> list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("select * from batch");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {			
				
				DateFormat DF = new SimpleDateFormat("yyyy/MM/dd");
				
				list.add(new Batch(rs.getString("batch_name"), DF.format(rs.getDate("batch_startdate")), DF.format(rs.getDate("batch_enddate")), rs.getInt("batch_capacity"), rs.getString("batch_Strength") , rs.getInt("course_id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException();
		}
		
		return list;
	}
	
	// this delete student account with student firstname

	@Override
	public String deleteStudentAccount(String firstname) throws StudentException {
		String message = "Student deleted sucessfully";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("update student set is_deleted = 1 WHERE firstname = ?");
			ps.setString(1, firstname);
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Student removed successfully";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return message;
	}
	
	// it enroll student into particular course with course id and student roll 

	@Override
	public String enrollStudentInCourse(int roll, int cid) throws StudentException, CourseException {
		
		String message = "Not Enrolled...!";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps1 = conn.prepareStatement("select * from student where student_id = ?");
			
			ps1.setInt(1, roll);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("select * from batch where batch_id = ?");
				
				ps2.setInt(1, cid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				
				if(rs2.next()) {
					
					PreparedStatement ps3 = conn.prepareStatement("insert into student_batch values (?,?)");
					
					ps3.setInt(1, roll);
					ps3.setInt(2, cid);
					
					int x = ps3.executeUpdate();
					
					if(x > 0) {
						
						message = "Student Enrolled Successfully ";
						
					}		
				}
				else
					throw new CourseException("course not found with this cid :" + cid);
	
			}
			else
				throw new StudentException("Student does not exist with this roll :" + roll);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}

		return message;
	}
	
	
}



