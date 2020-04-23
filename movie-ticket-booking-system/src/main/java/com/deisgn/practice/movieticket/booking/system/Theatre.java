package com.deisgn.practice.movieticket.booking.system;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

	private int theatreId;
	private List<Screen> screens;
	private Address address;

	public Theatre() {
		screens = new ArrayList<>();
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}