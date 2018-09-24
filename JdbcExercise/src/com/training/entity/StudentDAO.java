package com.training.entity;

import java.util.List;

public interface StudentDAO {

	public int addStudent(Student student) throws Exception;
	
	public List<Student> findAll() throws Exception;

	public Student findStudentById(long studentId) throws Exception;
	
	public List<Student> findStudentsByCourse(double courseId) throws Exception;
}
