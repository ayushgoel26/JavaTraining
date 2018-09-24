package com.training.entity;

import java.io.Serializable;

public class Student implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	private String studentName;
	private double studentId; 
	private double courseId;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String studentName, double studentId, double courseId) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public double getStudentId() {
		return studentId;
	}

	public void setStudentId(double studentId) {
		this.studentId = studentId;
	}

	public double getCourseId() {
		return courseId;
	}

	public void setCourseId(double courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Student : studentName = " + studentName + ", studentId = " + studentId + ", courseId = " + courseId;
	}
	
	
	
	
}
