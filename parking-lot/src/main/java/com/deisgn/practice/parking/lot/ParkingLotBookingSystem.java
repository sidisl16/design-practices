package com.deisgn.practice.parking.lot;

import java.util.List;

public class ParkingLotBookingSystem extends ParkingLotTemplate {

	protected ParkingLotBookingSystem(ParkingLot parkingLot) {
		super(parkingLot);
	}

	@Override
	protected Vehicle registerVehicle(Vehicle vehicle) {
		System.out.println(vehicle.getNumberPlate() + " Registered Successfully!");
		return vehicle;
	}

	@Override
	protected Row isParkingAvailable(VehicleSize vehicleSize, int slotsNeeded) {
		System.out.println("Searching parking space for " + vehicleSize.name() + " " + slotsNeeded);
		return parkingLot.getLevels().get(0).getRows().get(0);
	}

	@Override
	protected Booking book(Vehicle vehicle, Row row) {
		System.out.println("Booking parking for " + vehicle.getNumberPlate() + " in row " + row.getRowNo());
		Booking booking = new Booking.BookingBuilder().setLevelNo(row.getLevelNo()).setRowNo(row.getRowNo())
				.setSlots(row.getSlots()).setVehicle(vehicle).build();
		row.getSlots().get(0).setOccupied(Boolean.TRUE);
		parkingLot.getBookings().add(booking);
		return booking;
	}

	@Override
	protected Booking searchingBooking(Vehicle vehicle) {
		System.out.println("Searching booking for vehicle " + vehicle.getNumberPlate());
		return parkingLot.getBookings().get(0);
	}

	@Override
	protected Payment pay(Booking booking) {
		System.out.println("Payment for booking " + booking.getBookingId());
		Payment payment = new Payment(booking.getBookingId(), PaymentStatus.SUCCESS, PaymentMode.CASH);
		return payment;
	}

	@Override
	protected void clearSlot(List<Slot> slots) {
		System.out.println("Clearing slots");
		slots.forEach(slot -> slot.setOccupied(Boolean.FALSE));
	}

}
