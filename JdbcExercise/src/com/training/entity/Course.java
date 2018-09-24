package com.training.entity;

import java.util.*;

public class Course {
	private String courseName;
	private double courseId;
	private List<Student> studentList;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName, double courseId) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseId() {
		return courseId;
	}

	public void setCourseId(double courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + "]";
	}
	
	
	
}
