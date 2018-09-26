package com.training;

public class ApplicationMap {
	public static void main(String[] args) {
		MyMap<Integer, String> map1 = new MyMap<>();
		System.out.println(map1);
		
		System.out.println(map1.put(1,"Hello"));
		System.out.println(map1.put(2,"Java"));
		System.out.println(map1.put(3,"World"));
		System.out.println(map1.put(4,"!!"));
		System.out.println("");
		System.out.println("");

		System.out.println(map1.get(1));
		System.out.println(map1.get(2));
		System.out.println(map1.get(3));
		System.out.println(map1.get(4));

		System.out.println(map1.convertToSet());
		
		System.out.println("");
		
		
		
		
	}
}
