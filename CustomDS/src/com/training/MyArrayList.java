package com.training;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
	
	private int size = 0;
	private static int CAPACITY = 10;
	private Object elements[];
	
	public MyArrayList() {
		
		super();
		this.elements[CAPACITY] = elements;

	}
	
	public void add(Object newElement){
		
	
		if(this.size == elements.length ){
			updateCapacity();
		}
		
		elements[size++] = newElement;
		
	}
	
	
	public void updateCapacity(){
		 
		int newLength = this.size * 2;
		elements = Arrays.copyOf(elements, newLength);
		
	}
	
	
	public Object getByIndex(int idx) throws ArrayIndexOutOfBoundsException{
		
		Object obj = null;
		if(idx<elements.length){
			obj = elements[idx];
		}
		else{
			throw new ArrayIndexOutOfBoundsException();
		}
		return obj;
	}
	
	public boolean removeByIndex(int idx) throws ArrayIndexOutOfBoundsException{
		
		boolean status = false;
		if(idx<elements.length){
			for(int i = 0; i<this.size;i++){
				if(i>=idx){
					elements[i] = elements[i+1];
				}
			}
			status = true; 
			size--;
		}
		else{
			throw new ArrayIndexOutOfBoundsException();
		}
		return status;
	}

	 @Override
	    public Iterator<E> iterator() {
	        return new Iterator<E>() {

	            private int currIdx = 0;

	            @Override
	            public boolean hasNext() {
	                return currIdx < size && elements[currIdx] != null;
	            }

	            @Override
	            public E next() {
	                return (E) elements[currIdx++];
	            }
	            
	        };

	    }
	
	
	
	
	
	
	
	
}
