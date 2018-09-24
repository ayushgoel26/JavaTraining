package com.training.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.*;
import com.training.util.*;

public class StudentDAOImpl implements StudentDAO {

	private Connection con; 

	public StudentDAOImpl() {
		super();
		con = DbConnection.getOracleConnection();
	}

	@Override
	public int addStudent(Student student) throws Exception {

		String sql = "Insert into student_ag values(?,?,?)";
		PreparedStatement pstmt = null;

		int rowAdded = 0;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, student.getStudentId());
		pstmt.setString(2, student.getStudentName());
		pstmt.setDouble(3, student.getCourseId());

		rowAdded = pstmt.executeUpdate();
		pstmt.close();

		return rowAdded;
	}

	@Override
	public List<Student> findAll() throws Exception {

		String sql = "select * from student_ag";
		PreparedStatement pstmt = null;

		List<Student> studentList = new ArrayList<>();

		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			double courseId = rs.getDouble("courseId");
			String studentName = rs.getString("studentName");
			double studentId = rs.getDouble("studentId");
			
			Student student = new Student(studentName, studentId, courseId);
			studentList.add(student);
		}
		
		pstmt.close();
		return studentList;
		
	}

	@Override
	public Student findStudentById(long studentId) throws Exception {
		String sql = "select * from student_ag where studentId = ?";
		PreparedStatement pstmt = null;
		Student student = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, studentId);

		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			String studentName = rs.getString("courseName");
			double courseId = rs.getDouble("courseId");
			student = new Student(studentName, studentId, courseId);
		}

		pstmt.close();
		
		return student;
	}

	@Override
	public List<Student> findStudentsByCourse(double courseId) throws Exception {

		String sql = "select studentName,studentId,courseName,courseId from student_ag natural join course_ag where courseId = ?";
		PreparedStatement pstmt = null;

		List<Student> studentList = new ArrayList<>();

		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, courseId);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String studentName = rs.getString("studentName");
			double studentId = rs.getDouble("studentId");
			String courseName = rs.getString("courseName");
			
			System.out.println("studentName: " + studentName + ", studentId: " + studentId + ",  courseId: " + courseId + ", courseName: " + courseName);
			
			Student student = new Student(studentName, studentId, courseId);
			studentList.add(student);
		}
		
		pstmt.close();
		return studentList;
	}

}
