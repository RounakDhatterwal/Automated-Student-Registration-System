package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	@Override
	public String addStudents(Student student) throws StudentException {
		String message = "Student not added correctly";
		
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
				message = "Student Added Sucessfully";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException();
		}

		return message;
	}
	
	
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
				message = "Student Added Sucessfully";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return message;
	}

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
	
	@Override
	public String changePassword(String password) {
		String message  = "Password not updated sucessfully";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("update student set password = ? WHERE password  = ? " );
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Password updated sucessfully";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
		
	}
	

	@Override
	public List<Course> available_course_list() throws CourseException {
		List<Course> list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			PreparedStatement ps = con.prepareStatement("select * from course");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Course(rs.getString("name"), rs.getInt("fee"), rs.getInt("duration"), rs.getString("description")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException();
		}
		
		return list;
	}

	@Override
	public List<Batch> available_batches_list() throws BatchException {
		List<Batch> list = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("select * from batch");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Batch ba = new Batch();
				ba.setName(rs.getString(1));
//				ba.setStartdate(Date.valueOf(rs.getDate(2)));
				
				
				
//				list.add(new Batch(rs.getString("name"), rs.getDate(Date.valueOf("startdate")), rs.getDate("enddate"), rs.getString("capacity"), rs.getInt("course_id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException();
		}
		
		return list;
	}

	@Override
	public String registerIntoCourseAndBatch() throws CourseException, BatchException {
		String message = "Unable to register into course and batch";
		
		try (Connection con =  DBUtil.provideConnection()){
			
			con.prepareStatement("insert into batch ");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException();
		}
		
		return message;
	}

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
			// TODO: handle exception
		}
		
		return message;
	}


}
