package com.training;

import java.util.Iterator;

public class Application {
public static void main(String[] args) {
	

	try {
		MyArrayList<String> nameList = new MyArrayList<>();

		nameList.add("A");
		nameList.add("B");
		nameList.add("C");
		nameList.add("D");
		nameList.add("A");
		nameList.add("B");
		nameList.add("C");
		nameList.add("D");		
		nameList.add("A");
		nameList.add("B");
		nameList.add("C");
		nameList.add("D");
		
		Iterator<String> itr = nameList.iterator();

		while(itr.hasNext()){
			System.out.println(itr.next());
		}

		nameList.removeByIndex(2);
		Iterator<String> itr1 = nameList.iterator();

		while(itr1.hasNext()){
			System.out.println(itr1.next());
		}
		
		System.out.println(nameList.getByIndex(5));
	} catch (ArrayIndexOutOfBoundsException e) {
		e.printStackTrace();
	}

}	
	
	
}
