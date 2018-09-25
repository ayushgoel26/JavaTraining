package com.training.domains;

import java.util.*;

public class Application {

	public static void main(String[] args) {

		Product sonyTV = new Product(101,"Sony TV", "tv", 45000);
		Product samsungTV = new Product(102,"Samsung TV", "tv", 55000);
		Product hitachiTV = new Product(103,"Hitachi TV", "tv", 65000);
		Product lgRef = new Product(201,"LG Refrigerator", "fridge", 25000);
		Product samsungRef = new Product(202,"Samsung Refrigerator", "fridge", 35000);
		Product haierRef = new Product(203,"Haier Refrigerator", "fridge", 20000);
		
		List<Product> prdList = new ArrayList<>();
		
		prdList.add(sonyTV);
		prdList.add(samsungTV);
		prdList.add(hitachiTV);
		prdList.add(lgRef);
		prdList.add(samsungRef);
		prdList.add(haierRef);
		
		ManageProducts mgr = new ManageProducts();
		mgr.printProductByCategory("fridge", prdList);
		mgr.printProductNames(prdList);
		mgr.printCategory(prdList);
		mgr.printSortedList(prdList);
		System.out.println("Maximum Price: " + mgr.findMaxPricedProduct(prdList));
		System.out.println("Minimum Price: " + mgr.findMinPricedProduct(prdList));
		System.out.println("Number of Products : " + mgr.countProduct(prdList));
		System.out.println("Minimum Price: " + mgr.findMinMax(prdList, true));
		System.out.println("Maximum Price: " + mgr.findMinMax(prdList, false));
		
		Map<String,Double> priceList = mgr.getPriceList(prdList);
		System.out.println(priceList.get("Samsung Refrigerator"));
	
		Set<Map.Entry<String, Double>> items = priceList.entrySet();
		for(Map.Entry<String, Double> eachItem : items){
			
			System.out.println(eachItem.getKey());
			System.out.println(eachItem.getValue());
			
		}
	
		System.out.println(mgr.totalAmt(prdList));
	}
	
	

}
