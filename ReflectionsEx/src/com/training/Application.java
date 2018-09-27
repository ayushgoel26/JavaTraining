package com.training;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Application {

	public static void main(String[] args) {		
		
		
		try {
			
			Class<?> cls= Class.forName("com.training.Movie");
			
			Movie diamond = (Movie) cls.newInstance();

			diamond.setMovieId(203);
			diamond.setMovieName("Titanic");

			System.out.println(diamond.toString());

			Constructor<?>[] constructorList = cls.getDeclaredConstructors();

			for (Constructor<?> constructor : constructorList) {
				System.out.println("Name: " + constructor.getName());
				System.out.println("Parameter Count: " + constructor.getParameterCount());
			} 
			
			Method[] methodList = cls.getDeclaredMethods();
			
			for(Method eachMethod : methodList){
				System.out.println(eachMethod.getName());
				System.out.println(eachMethod.getReturnType());
				Class[] types = eachMethod.getParameterTypes();
				for(Class cls1 : types){
					System.out.println(cls1);
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
