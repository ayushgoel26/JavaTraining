package com.training;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuickStartTest {
	QuickStart obj;
	
	@Before
	public void init(){
		obj = new QuickStart();

	}
	
	@Test
	public void testGetMessage() {
		String expected = "HELLO";
		String actual = obj.getMessage();
		
		assertEquals("Testing Return type of getMessage() : ", expected, actual);
	}

	@Test
	public void calculateDiscountTestCase1(){
		
		double expected = 0.10;
		double actual = obj.calculateDiscount(4000);
		
		assertEquals("Should return 0.10", expected, actual, 2);
	} 
	
	@Test
	public void calculateDiscountTestCase2(){
		
		double expected = 0.15;
		double actual = obj.calculateDiscount(6000);
		
		assertEquals("Should return 0.15", expected, actual, 2);
	} 

	@Test
	public void calculateDiscountTestCase3(){
		
		double expected = 0.10;
		double actual = obj.calculateDiscount(5000);
		
		assertEquals("Should return 0.15", expected, actual, 2);
	} 
	
	@Test(expected = RuntimeException.class)
	public void calculateDiscountTestCase4(){
		
		obj.calculateDiscount(-1);
		
	} 
	
	
	
	
}
