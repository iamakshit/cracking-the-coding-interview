package com.java.tech.interview.mobikwik;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;

public class MobikWikMainClass {

	static String json = "{a:\"X\",b:\"2\",d:\"13\"}";

	public static MWClass generateClass(String json, MWClass objectInstance)
			throws IllegalArgumentException, IllegalAccessException {

		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		String[] parts = json.replaceAll("^\\{|\\}$", "").split("\"?(:|,)(?![^\\{]*\\})\"?");
		StringBuilder strBuilder = new StringBuilder(parts[parts.length - 1]);
		strBuilder.setLength(strBuilder.length() - 2);
		parts[parts.length - 1] = strBuilder.toString();

		for (int i = 0; i < parts.length - 1; i += 2) {
			map.put(parts[i], parts[i + 1]);
			System.out.println(parts[i + 1]);
		}

		for (Field field : objectInstance.getClass().getDeclaredFields()) {
			String name = field.getName();
			String value = map.get(name);
			if (field.getType().getName() == "java.lang.Integer") {
				Integer x = Integer.parseInt(value);
				field.set(objectInstance, x);
			} else {
				field.set(objectInstance, value);
			}
		}

		System.out.println(objectInstance);
		return objectInstance;
	}

	public static void main(String args[]) {

		MWClass obj = new MWClass();
		try {
			obj = generateClass(json, obj);
		} catch (Exception e) {
			System.out.println();
		}

	}
}
