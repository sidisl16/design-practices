package com.deisgn.practice.parking.lot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

	private List<Level> levels;
	private List<Booking> bookings;

	public ParkingLot() {
		levels = new ArrayList<>();
		bookings = new ArrayList<>();
	}

	public List<Level> getLevels() {
		return levels;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

}
