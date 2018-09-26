package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Application {

	public static void main(String[] args) {

		AddNumber<Double,String> marks = new AddNumber<>();
		
			marks.setDigit(98.3);
			marks.addObject("Ayush");
		
		AddNumber<Integer,String> age = new AddNumber<>();
		
			age.setDigit(23);
			age.addObject("Ramesh");
		
		System.out.println(marks.getList() + " - " + marks.getDigit());
		System.out.println(age.getList() + " - " + age.getDigit());

		List<Integer> markList = Arrays.asList(20,30,40);
		List<Double> mathList = Arrays.asList(20.03,30.40,40.5);
		List<Object> studList = Arrays.asList(new Boolean(true), new Boolean(false), new Boolean(true));

		System.out.println(showNumberList(markList));
		System.out.println(showNumberList(mathList));
		
		print(markList);
		print(mathList);
		print(studList);
		
		
		
		addTolist(markList);
		//addTolist(mathList);
		addTolist(studList);
		
		
	}
	
	// Generic Methods - Type 1 
	
	public static <T> T showNumberList(List<T> numList) {
		
		return numList.get(2);
		
	}
	
	
	// Generic Methods - Type 2 

	public static void print(List<?> list){
		list.forEach(System.out::println);
	}
	

	// Generic Methods - Type 3 - Producer 

	public static void printList(List<? extends Number> list){
		list.forEach(System.out::println);	
		
	}
	

	// Generic Methods - Type 4 - Consumer 

	public static void addTolist(List<? super Integer> list){
		list.set(2,007); 	
		list.add(22);
	}
	
}
