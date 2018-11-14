package com.java.tech.ood.callcenter;

import java.util.HashMap;
import java.util.LinkedList;

import com.java.tech.ood.callcenter.employee.Employee;

public class CallCenter {

	public static CallCenter callCenter;

	HashMap<Integer, Employee> employees;
	LinkedList<Employee> availableRespondents;

	private CallCenter() {

		employees = new HashMap<>();
		availableRespondents = new LinkedList<>();
	}

	public static CallCenter getInstance() { // This method will always be static
		if (callCenter == null) {
			callCenter = new CallCenter();
		}
		return callCenter;
	}

	private Employee getCallHandler(Call call) {
		return availableRespondents.pollFirst();
	}

	public void handleCall(Call call) {

		Employee respondent = getCallHandler(call);
		while (respondent != null && !respondent.isAvailable()) {
			respondent = employees.get(respondent.getSeniorId());
		}

	}

}
