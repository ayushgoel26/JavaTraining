package com.training;

import java.util.ArrayList;
import java.util.List;

public class AddNumber<T,E> {

	private T digit;
	private List<E> list;
	
	
	
	
	public AddNumber() {
		super();
		list = new ArrayList<>();
	}
	
	public void addObject(E element){
		list.add(element);
	}
	
	public List<E> getList(){
		return list;
	}

	public T getDigit() {
		return digit;
	}

	public void setDigit(T digit) {
		this.digit = digit;
	} 
	
	
	
	
	
	
	
}
