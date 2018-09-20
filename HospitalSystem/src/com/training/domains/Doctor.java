package com.training.domains;

public class Doctor {
	private String docName;
	private String docSpec;
	private int docAge;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String docName, String docSpec, int docAge) {
		this.docName = docName;
		this.docSpec = docSpec;
		this.docAge = docAge;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocSpec() {
		return docSpec;
	}
	public void setDocSpec(String docSpec) {
		this.docSpec = docSpec;
	}
	public int getDocAge() {
		return docAge;
	}
	public void setDocAge(int docAge) {
		this.docAge = docAge;
	}
	@Override
	public String toString() {
		return "Doctor [docName=" + docName + ", docSpec=" + docSpec + ", docAge=" + docAge + "]";
	}
	
	
}
