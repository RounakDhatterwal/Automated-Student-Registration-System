package com.masai.dao;

import java.util.List;

import com.masai.model.Batch;
import com.masai.model.Course;

public interface AdminstratorDao {
	public String login(String username, String password);
	
	public String addnewCourse(Course course);
	
	public Course searchCourseDetails(String course_name, int time, int fee);
	
	public String updateCourseDetails(int courseID);
	
	public Batch createBatchUnderACoruse(Batch batch);
	
	public String searchBatch(String batch_name, String start_date, String end_date);
	
	public String updateBatch(int batchid);
	
	public String viewStudentDetails(int student_id);
	
	public List<String> studentListofBatch(int batch_id);
	
	public String getReport(int course_id, int batch_id);
}
