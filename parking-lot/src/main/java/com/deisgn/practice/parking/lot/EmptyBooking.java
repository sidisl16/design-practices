package com.deisgn.practice.parking.lot;

//Null Object pattern
public class EmptyBooking implements IBooking {

	@Override
	public String getBookingId() {
		return "Booking cannot be done.";
	}

}
