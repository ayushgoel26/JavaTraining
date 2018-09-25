package com.training;

import com.training.dao.impl.*;
import com.training.entity.*;
import com.training.util.DbConnection;

public class Application {

	public static void main(String[] args) {
		System.out.println(DbConnection.getOracleConnection());
		CourseDAO courseDao = new CourseDAOImpl();
		StudentDAO studentDao = new StudentDAOImpl();

		int key = 3;
		
		try {
			switch (key) {
			
			case 1:
				Course java = new Course( "Java" , 101);
				Course dotNet = new Course("Dot Net",102);
				int a = courseDao.addCourse(java); 
				a += courseDao.addCourse(dotNet);
				System.out.println(a + ":= Course added");
				break;
			
			case 2:
				Student ram = new Student("ram", 001, 101);
				Student shyam = new Student("shyam", 002, 102);
				Student rai = new Student("rai", 003, 102);
				Student karan = new Student("karan", 004, 101);
				int a1 = studentDao.addStudent(ram);
				a1 += studentDao.addStudent(shyam);
				a1 += studentDao.addStudent(rai);
				a1 += studentDao.addStudent(karan);
				System.out.println(a1 + ":= Row Added");
				break;

			case 3: 
				Course course = studentDao.findStudentsByCourse(101);
				System.out.println(course);
				System.out.println("---");
				course.getStudentList().forEach(System.out::println);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
