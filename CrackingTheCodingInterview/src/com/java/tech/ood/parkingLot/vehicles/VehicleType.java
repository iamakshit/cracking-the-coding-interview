package com.java.tech.ood.parkingLot.vehicles;

public enum VehicleType {

	CAR("Car", 2), BIKE("Small", 1), BUS("Medium", 3);

	String code;
	Integer minSlotNum;

	private VehicleType(String code, Integer minSlot) {
		this.code = code;
		this.minSlotNum = minSlot;
	}

}
