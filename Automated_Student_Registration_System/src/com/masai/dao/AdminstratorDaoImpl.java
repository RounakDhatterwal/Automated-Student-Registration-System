package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Utility.DBUtil;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.Student;

public class AdminstratorDaoImpl implements AdminstratorDao{

	public static boolean flag = false;
	
	@Override
	public String login(String username, String password) {
		String message = "Wrong credentials";
		
		if(username == "admin" && password == "admin") {
			message = "Login Sucessfully";
			flag = true;
		}
		
		return message;
	}

	@Override
	public String addnewCourse(Course course) throws CourseException {
		String message = "Unable to add new course";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into course (course_name, course_fee, course_duration, course_description) values(?,?,?,?)");
			ps.setString(1, course.getName());
			ps.setInt(2, course.getFee());
			ps.setInt(3, course.getDuration());
			ps.setString(4, course.getDescription());
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "New Course Addded Successfully";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CourseException();
		}
		
		return null;
	}

	@Override
	public List<Course> searchCourseDetails(String course_name, int time, int fee) throws CourseException {
		List<Course> list = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from course where course_name = ? OR Course_duration = ? OR course_fee = ?");
			ps.setString(1, course_name);
			ps.setInt(2, time);
			ps.setInt(3, fee);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Course co = new Course();
				co.setName(rs.getString("course_name"));
				co.setFee(rs.getInt("course_fee"));
				co.setDuration(rs.getInt("course_duration"));
				co.setDescription(rs.getString("course_description"));
				list.add(co);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CourseException();
		}
		
		return list;
	}

	@Override
	public String updateCourseDetails(int courseID) throws CourseException {
		String message ="Course Updated Sucessfully";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("update car set course_name = ? , course_fee = ? , course_duration = ? , course_description = ?  WHERE course_id = ?");
//			ps.setString(1,course.ge)
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException();
		}
		
		return message;
	}

	@Override
	public Batch createBatchUnderACoruse(Batch batch) throws BatchException {
		Batch ba = new Batch();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into batch (batch_name, batch_startdate, batch_enddate, batch_capacity, course_id) values(?,?,?,?,?)");
			ps.setString(1, batch.getName());
			ps.setDate(2, batch.getStartdate());
			ps.setDate(3, batch.getEnddate());
			ps.setString(4, batch.getCapacity());
			ps.setInt(5, batch.getCourse_id());
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException();
		}
		
		
		return ba;
	}

	@Override
	public String searchBatch(String batch_name, String start_date, String end_date) {
		String message = "Batch details not found";
		
		
		
		return message;
	}

	@Override
	public String updateBatch(int batch_id) {
		String message = "Batch updated sucessfully";
		
		return message;
	}

	@Override
	public List<Student> viewStudentDetails(int student_id) {
		List<Student> stu = new ArrayList<>();
		
		
		return stu;
	}

	@Override
	public List<String> studentListofBatch(int batch_id) {
		List<String> stu = new ArrayList<>();
		
		
		return stu;
	}

}
