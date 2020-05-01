package com.deisgn.practice.parking.lot;

import java.util.List;

public abstract class ParkingLotTemplate {

	protected ParkingLot parkingLot;

	protected ParkingLotTemplate(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	protected abstract Vehicle registerVehicle(Vehicle vehicle);

	protected abstract Row isParkingAvailable(VehicleSize vehicleSize, int slotsNeeded);

	protected abstract Booking book(Vehicle vehicle, Row row);

	protected abstract Booking searchingBooking(Vehicle vehicle);

	protected abstract Payment pay(Booking booking);

	protected abstract void clearSlot(List<Slot> slots);

	public IBooking book(Vehicle vehicle) {

		vehicle = registerVehicle(vehicle);
		Row row = isParkingAvailable(vehicle.getVehicleSize(), vehicle.getSlotsNeeded());

		if (row == null) {
			System.out.println("Parking not available!");
			return new EmptyBooking();
		}

		Booking booking = book(vehicle, row);

		return booking;

	}

	public PaymentStatus exit(Vehicle vehicle) {

		IBooking booking = searchingBooking(vehicle);

		if (booking instanceof EmptyBooking) {
			System.out.println("Rogue vehicle found.");
			return PaymentStatus.FAILED;
		}

		Payment payment = pay((Booking) booking);
		Booking book = (Booking) booking;

		clearSlot(book.getSlots());

		return payment.getPaymentStatus();
	}

}
