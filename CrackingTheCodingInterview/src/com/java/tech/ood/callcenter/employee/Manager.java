package com.java.tech.ood.callcenter.employee;

public class Manager extends Employee{

	
	Integer seniorId; //Director
	
	public Manager()
	{
		this.employeeType = EmployeeType.MANAGER;
	}
}
