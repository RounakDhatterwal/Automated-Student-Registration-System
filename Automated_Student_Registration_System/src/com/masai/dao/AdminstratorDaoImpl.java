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
import com.masai.model.Consolidate;
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
			if(list.size()==0) throw new CourseException("No Course Found");
			
		} catch (Exception e) {
			throw new CourseException(e.getMessage());
		}
		
		return list;
	}
	
	

	@Override
	public String updateCourseDetails(int courseID, String name, int fee, int duration, String description) throws CourseException {
		String message ="Course Not Updated Sucessfully";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("update course set course_name = ? , course_fee = ? , course_duration = ? , course_description = ?  WHERE course_id = ?");
			ps.setString(1,name);
			ps.setInt(2,fee);
			ps.setInt(3,duration);
			ps.setString(4,description);
			ps.setInt(5, courseID);
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Course Updated Sucessfully";
			}
			
		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public Batch createBatchUnderACoruse(Batch batch) throws BatchException {
		Batch ba = new Batch();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into batch (batch_name, batch_startdate, batch_enddate, batch_capacity, course_id) values(?,?,?,?,?)");
			ps.setString(1, batch.getName());
			ps.setDate(2, Date.valueOf(batch.getStartdate()));
			ps.setDate(3, Date.valueOf(batch.getEnddate()));
			ps.setInt(4, batch.getCapacity());
			ps.setInt(5, batch.getCourse_id());
			
			int row  = ps.executeUpdate();
//			if(row > 0) {
//				
//			}
//			
		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		
		
		return ba;
	}

	@Override
	public List<Batch> searchBatch(String batch_name, String start_date, String end_date) throws BatchException {
		List<Batch> ba = new ArrayList<>();
		
		try (Connection con =  DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("select * from batch where batch_name = ? OR batch_startdate = ? OR batch_enddate = ?");
			ps.setString(1, batch_name);
			ps.setString(2, start_date);
			ps.setString(3,end_date);
			
			ResultSet rs =  ps.executeQuery();
			while(rs.next()){
				Batch co = new Batch();
				co.setName(rs.getString("batch_name"));
				co.setStrength(rs.getString("batch_strength"));
				co.setCapacity(rs.getInt("batch_capacity"));
				co.setCourse_id(rs.getInt("course_id"));
				co.setStartdate(rs.getString("batch_startdate"));
				co.setEnddate(rs.getString("batch_enddate"));
				
				ba.add(co);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BatchException();
		}
		
		return ba;
	}

	@Override
	public String updateBatch(int batch_id, String batch_name, String start_date, String end_date, int capacity, int course_id) throws BatchException {
		String message = "Batch not updated sucessfully";
		
		try(Connection con = DBUtil.provideConnection()) {
														  
			PreparedStatement ps = con.prepareStatement("update batch set batch_name = ? , batch_startdate = ? , batch_enddate = ? , batch_capacity = ? , course_id = ? WHERE batch_id = ?");
			ps.setString(1, batch_name);
			ps.setString(2, start_date);
			ps.setString(3, end_date);
			ps.setInt(4, capacity);
			ps.setInt(5, course_id);
			ps.setInt(6, batch_id);
			
			int x = ps.executeUpdate();
			if(x>0) {
				message  = "Batch Updated Successfully";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException();
		}
		
		
		return message;
	}

	@Override
	public List<Student> viewStudentDetails(int student_id) throws StudentException {
		List<Student> list = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from student where student_id = ?");
			ps.setInt(1, student_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setFirstname(rs.getString("firstname"));
				stu.setLastname(rs.getString("lastname"));
				stu.setAddress(rs.getString("address"));
				stu.setMobile_number(rs.getString("mobile_number"));
				stu.setEmail(rs.getString("email"));
				stu.setPassword(rs.getString("password"));
				list.add(stu);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new StudentException();
		}
		
		return list;
	}

	@Override
	public List<String> studentListofBatch(int batch_id){
		List<String> list = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select s.firstname from student_batch b JOIN student s ON b.student_id = s.student_id WHERE b.batch_id = ?");
			ps.setInt(1, batch_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("firstname"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public  List<Consolidate> getReport() {
		 List<Consolidate> report = new ArrayList<>();
		 Consolidate co;
		 try(Connection con = DBUtil.provideConnection()) {
				
				PreparedStatement ps = con.prepareStatement("select c.course_id,count(b.batch_id),count(st.student_id) from course c INNER JOIN  batch b ON c.course_id = b.course_id \r\n"
						+ "INNER JOIN  student_batch sc ON b.batch_id = sc.batch_id INNER JOIN student st ON sc.student_id = st.student_id group by c.course_id;");
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					 co = new Consolidate();
					co.setC_id(rs.getInt(1));
					co.setBt_id(rs.getInt(2));
					co.setSt_id(rs.getInt(3));
					
					report.add(co);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		 return report;
	}


}
