package com.java.tech.ood.callcenter.employee;

import java.util.LinkedList;

import com.java.tech.ood.callcenter.Call;

public class Director extends Employee {

	LinkedList<Call> callList;

	public Director() {
		this.employeeType = EmployeeType.DIRECTOR;
		callList = new LinkedList<>();
	}
}
