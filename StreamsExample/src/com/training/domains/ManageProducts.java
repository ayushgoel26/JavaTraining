package com.training.domains;

import java.util.*;
import java.util.stream.Collectors;

public class ManageProducts {
	
	public void printProductByCategory(String category, List<Product> prdList){
		
		List<Product> catalog = prdList.stream().filter(eachProduct -> eachProduct.getCategory().equals(category)).collect(Collectors.toList());
		catalog.forEach(System.out::println);
		
	}
	
	public void printProductNames(List<Product> prdList){
		
		prdList.stream().map(product -> product.getProductName()).forEach(System.out::println);
	}
	
	public void printCategory(List<Product> prdList){
		
		prdList.stream().map(product -> product.getCategory()).distinct().forEach(System.out::println);
	}
	
	
	public void printSortedList(List<Product> prdList){
		
		// prdList.stream().sorted().forEach(System.out::println);
		prdList.stream().sorted(Comparator.comparing(Product::getRatePerUnit)).forEach(System.out::println);
	
	}
	
	
	public double findMaxPricedProduct(List<Product> prdList){
		double rate = 0.0;
		Optional<Product> result = prdList.stream().max(Comparator.comparing(Product::getRatePerUnit));
		if(result.isPresent()){
			 rate = result.get().getRatePerUnit();
		}
		return rate;
	}
	

	public double findMinPricedProduct(List<Product> prdList){
		double rate = 0.0;
		Optional<Product> result = prdList.stream().min(Comparator.comparing(Product::getRatePerUnit));
		if(result.isPresent()){
			 rate = result.get().getRatePerUnit();
		}
		return rate;
	}
	
	public double findMinMax(List<Product> prdList, boolean isMin){
		double rate = 0.0;
		Optional<Product> result = null;
		if(isMin){
			result = prdList.stream().min(Comparator.comparing(Product::getRatePerUnit));
		}else{
			result = prdList.stream().max(Comparator.comparing(Product::getRatePerUnit));
		}
		
		if(result.isPresent()){
			 rate = result.get().getRatePerUnit();
		}
		return rate;
	}
	

	public long countProduct(List<Product> prdList){
		long prdCount = prdList.stream().count();
		 return prdCount;
	}
	
	public Map<String, Double> getPriceList(List<Product> prdList){
		Map<String,Double> priceMap  = prdList.stream().collect(Collectors.toMap(Product::getProductName, Product::getRatePerUnit));
		
		return priceMap;
	}

	public double totalAmt(List<Product> prdList){
		Double result = prdList.parallelStream().map(p -> p.getRatePerUnit()).reduce(0.0, (p1,p2)->{p1+=p2; return p1;});
		return result;
	}
}
