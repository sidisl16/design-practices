package com.deisgn.practice.parking.lot;

import java.awt.Color;

public class Application {

	/**
	 * 
	 * Design a Parking Lot
	 * 
	 * Requirements:
	 * 
	 * 1. Allocating vehicle to parking lot 2. get payment status at the time of
	 * exit
	 * 
	 * Solution:
	 * 
	 * Using template pattern
	 * 
	 * 
	 */
	public static void main(String[] args) {

		// Test Data
		ParkingLot parkingLotData = getParkingLotData();

		// Client code
		ParkingLotTemplate parkingLot = new ParkingLotBookingSystem(parkingLotData);

		Vehicle vehicle = getVehicle();

		IBooking booking = parkingLot.book(vehicle);
		System.out.println("Booking done reffernce no -> " + booking.getBookingId());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		PaymentStatus paymentStatus = parkingLot.exit(vehicle);

		System.out.println("Payment done status -> " + paymentStatus.name());

	}

	private static Vehicle getVehicle() {
		Vehicle vehicle = new Vehicle.VehicleBuilder(VehicleSize.TWOWHEELER, 9876).setColor(Color.black)
				.setModel("Bajaj Avenger 220").build();
		return vehicle;
	}

	private static ParkingLot getParkingLotData() {
		ParkingLot parkingLot = new ParkingLot();

		Slot slot = new Slot(0, 1);
		Row row = new Row(0, 1);
		row.getSlots().add(slot);

		Level level = new Level(parkingLot, 1);
		level.getRows().add(row);

		parkingLot.getLevels().add(level);
		return parkingLot;
	}
}
