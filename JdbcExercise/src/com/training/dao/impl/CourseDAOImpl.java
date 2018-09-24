package com.training.dao.impl;

import java.sql.*;
import java.util.*;
import com.training.util.*;
import com.training.entity.*;

public class CourseDAOImpl implements CourseDAO {
	private Connection con;

	public CourseDAOImpl() {
		super();
		con = DbConnection.getOracleConnection();
	}
	
	@Override
	public int addCourse(Course course) throws Exception {
		
		String sql = "Insert into course_ag values(?,?)";
		
		PreparedStatement pstmt = null;
		
		int rowAdded = 0;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, course.getCourseId());
		pstmt.setString(2, course.getCourseName());

		rowAdded = pstmt.executeUpdate();

		pstmt.close();

		return rowAdded;
		
	}

	@Override
	public List<Course> findAll() throws Exception {
		String sql = "select * from course_ag";
		PreparedStatement pstmt = null;

		List<Course> courseList = new ArrayList<>();

		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			double courseId = rs.getLong("courseId");
			String courseName = rs.getString("courseName");
			Course course = new Course(courseName, courseId);
			courseList.add(course);
		}
		
		pstmt.close();
		return courseList;
	}

	@Override
	public Course findCourseById(double courseId) throws Exception {
		String sql = "select * from course_ag where courseId = ?";
		PreparedStatement pstmt = null;
		Course course = null;

		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, courseId);

		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			String courseName = rs.getString("courseName");
			
			course = new Course(courseName, courseId);
		}

		pstmt.close();
		return course;
	}

	public void closeConnection() {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
