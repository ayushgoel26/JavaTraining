package com.training.domains;

public class Employee {
	private String empName;
	private int empAge;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String empName, int empAge) throws RangeCheckException{
		super();
		this.empName = empName;
		
		if(empAge>58 || empAge<18){
			throw new RangeCheckException("Age out of bound");
		}
		else{
			this.empAge = empAge;
		}
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		try {
			if(empAge>58 || empAge<18){
				throw new RangeCheckException("Age out of bound");
			}
			else{
				this.empAge = empAge;
			}
		} catch (RangeCheckException e) {
			System.err.println(e.getMessage());
		}
	} 
	
	
	
}
