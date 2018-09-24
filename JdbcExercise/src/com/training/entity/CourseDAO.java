package com.training.entity;

import java.util.List;

public interface CourseDAO {

	public int addCourse(Course course) throws Exception;
	public List<Course> findAll() throws Exception;

	public Course findCourseById(double courseId) throws Exception;

}
