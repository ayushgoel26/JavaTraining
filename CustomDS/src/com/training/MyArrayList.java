package com.training;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
	
	private int size = 0;
	private static int CAPACITY = 10;
	private Object elements[];
	private int lastIndex = 0;
	
	public MyArrayList() {
		
		super();
		this.size = CAPACITY;
		this.elements = new Object[CAPACITY];
		this.lastIndex = 0;
	}
	
	public void add(Object newElement){
		
	
		if(this.lastIndex == elements.length ){
			updateCapacity();
		}
		elements[lastIndex++] = newElement;
		
	}
	
	
	public void updateCapacity(){
		 
		int newLength = this.size * 2;
		elements = Arrays.copyOf(elements, newLength);
		
	}
	
	
	public Object getByIndex(int idx) throws ArrayIndexOutOfBoundsException{
		
		Object obj = null;
		if(idx<lastIndex){
			obj = elements[idx];
		}
		else{
			throw new ArrayIndexOutOfBoundsException();
		}
		return obj;
	}
	
	public boolean removeByIndex(int idx) throws ArrayIndexOutOfBoundsException{
		
		boolean status = false;
		if(idx<lastIndex){
			for(int i = 0; i<lastIndex;i++){
				if(i>=idx){
					elements[i] = elements[i+1];
				}
			}
			status = true; 
			lastIndex--;
		}
		else{
			throw new ArrayIndexOutOfBoundsException();
		}
		return status;
	}

	 @Override
	    public Iterator<T> iterator() {
	        return new Iterator<T>() {

	            private int currIdx = 0;

	            @Override
	            public boolean hasNext() {
	                return currIdx < lastIndex && elements[currIdx] != null;
	            }

	            @Override
	            public T next() {
	                return (T) elements[currIdx++];
	            }
	            
	        };

	    }
}
