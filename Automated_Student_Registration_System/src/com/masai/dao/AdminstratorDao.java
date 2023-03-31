package com.masai.dao;

import java.sql.Date;
import java.util.List;

import com.masai.exception.AdministratorException;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.Student;

public interface AdminstratorDao {
	
	// 1. Login his account
	public String login(String username, String password)throws AdministratorException;
	
	// 2. Add new Courses
	public String addnewCourse(Course course)throws CourseException;
	
	// 3. Search for information about courses (by course name, duration range and fee range)
	public List<Course> searchCourseDetails(String course_name, int time, int fee)throws CourseException;
	
	// 4. Update details of course
	public String updateCourseDetails(int courseID, String name, int fee, int duration, String description)throws CourseException;
	
	// 5. Create a Batch under a course.
	public Batch createBatchUnderACoruse(Batch batch)throws CourseException,BatchException;
	
	// 6. Search for information about batches (by batch name, by start date range, by end date
	//    range, by start and end date. By course name of the batch)
	public Batch searchBatch(String batch_name, String start_date, String end_date)throws BatchException;
	
	// 6. Update details of batch
	public String updateBatch(int batch_id, String batch_name, Date sdate, Date edate, String capacity, int course_id)throws BatchException;
	
	// 7. View student details
	public List<Student> viewStudentDetails(int student_id)throws StudentException;
	
	// 8. View the student list of a batch
	public List<String> studentListofBatch(int batch_id)throws StudentException;


//	public String getReport(int course_id, int batch_id);
}
