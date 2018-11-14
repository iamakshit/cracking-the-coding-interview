package com.java.tech.ood.onlineBookReader;

import java.util.HashMap;

public class UserSystem {

	HashMap<Integer, User> userMap;
	static UserSystem instance = null;

	private UserSystem() {
		userMap = new HashMap<Integer, User>();
	}
	
	public static UserSystem getInstance()
	{
		if(instance == null)
		{
			instance = new UserSystem();
		}
		return instance;
	}
	public void addUser()
	{
		
	}
}
