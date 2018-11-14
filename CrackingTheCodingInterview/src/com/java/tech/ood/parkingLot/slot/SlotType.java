package com.java.tech.ood.parkingLot.slot;

import java.util.HashMap;

public enum SlotType {

	LARGE("Large", 3), SMALL("Small", 1), MEDIUM("Medium", 2);

	String code;
	Integer size;

	private SlotType(String code, Integer size) {
		this.code = code;
		this.size = size;

	}

	private static HashMap<Integer, SlotType> sizeToTypeMap = new HashMap<>();
	static {
		for (SlotType slotType : SlotType.values()) {
			sizeToTypeMap.put(slotType.getSize(), slotType);
		}
	}

	public static SlotType getSlotTypeForSize(int size) {
		return sizeToTypeMap.get(size);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public HashMap<Integer, SlotType> getSizeToTypeMap() {
		return sizeToTypeMap;
	}

	public void setSizeToTypeMap(HashMap<Integer, SlotType> sizeToTypeMap) {
		this.sizeToTypeMap = sizeToTypeMap;
	}

}
