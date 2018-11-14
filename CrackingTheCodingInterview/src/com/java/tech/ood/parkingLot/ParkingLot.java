package com.java.tech.ood.parkingLot;

import java.util.HashMap;

import com.java.tech.ood.parkingLot.slot.Slot;
import com.java.tech.ood.parkingLot.slot.SlotType;
import com.java.tech.ood.parkingLot.vehicles.Vehicle;

public class ParkingLot {
	HashMap<Integer, Slot> slots;
	HashMap<SlotType, Slot> availableSlots;
	HashMap<Integer, Vehicle> parkedVehicles;
	Integer totalNumLots;

	ParkingLot instance = null;

	private ParkingLot() {

	}

	private ParkingLot getParkingLot() {
		if (this.instance == null) {
			instance = new ParkingLot();
			setupParkingLot();

		}

		return instance;
	}

	private void setupParkingLot() {

	}

	public void parkCar() {

	}

	public void unParkCar() {

	}

}
