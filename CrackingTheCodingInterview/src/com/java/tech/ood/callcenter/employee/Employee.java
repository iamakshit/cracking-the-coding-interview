package com.java.tech.ood.callcenter.employee;

import java.util.List;

import com.java.tech.ood.callcenter.Call;

public class Employee {

	public enum EmployeeType {

		RESPONDANTS("Respondants"), MANAGER("Manager"), DIRECTOR("Director");

		String code;

		private EmployeeType(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	Integer employeeId;
	EmployeeType employeeType;
	List<Call> calls;
	boolean isAvailable = false;
	Integer seniorId;

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Integer getSeniorId() {
		return seniorId;
	}

	public void setSeniorId(Integer seniorId) {
		this.seniorId = seniorId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

}
