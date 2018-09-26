package com.training;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyMap<K, V> {

	private static final int DEF_CAPACITY = 10;
	private MapEntry<K, V>[] entries;
	private int size;
	private int maxIndex = 0; 
	
	@SuppressWarnings("unchecked")
	public MyMap() {
		super();
		this.entries = new MapEntry[DEF_CAPACITY];
		this.size = DEF_CAPACITY;
	}

	public MyMap(MapEntry<K, V>[] entries) {
		super();
		this.entries = entries;
		this.size = entries.length;
	}

	public MapEntry<K, V>[] getEntries() {
		return entries;
	}

	public void setEntries(MapEntry<K, V>[] entries) {
		this.entries = entries;
		this.size = entries.length;
	}

	public static int getDefCapacity() {
		return DEF_CAPACITY;
	}

	public V put(K key, V value) {
		V result = null;

		if (key != null) {
			System.out.println(key);
			System.out.println(value);

			for (int i = 0; i < size; i++) {

				if(entries[i] != null){
				if (entries[i].getKey() == key) {
					result = entries[i].getValue();
					entries[i].setKey(key);
					entries[i].setValue(value);
				}}
			}

			if (result == null) {
				entries[maxIndex]= new MapEntry<>();
				entries[maxIndex].setKey(key);
				entries[maxIndex++].setValue(value);
			}

		} else {
			System.out.println("NULL KEY CANNOT BE PASSED");
		}

		return result;
	}

	public V get(K key) {
		V result = null;
		
		if (key != null) {
			int i = 0;
			while (result == null && i < size) {
				if (entries[i].getKey() == key) {
					result = entries[i].getValue();
					entries[i].setKey(key);
				}
				i++;
			}
		} else {
			System.out.println("NULL KEY CANNOT BE PASSED");
		}

		return result;
	}
	
	public Set<MapEntry<K, V>> convertToSet(){
		HashSet<MapEntry<K, V>> convertedSet = new HashSet<>();
			
		for (int i = 0; i < size; i++) {
			
			convertedSet.add(entries[i]);
			
			
		}
		
		
		return convertedSet;
	}
	

}
