package com.deisgn.practice.movieticket.booking.system;

/**
 * Problem:
 * 
 * Design a movie ticket booking system like Bookmyshow We need to design an
 * online Movie ticket booking system where a user can search a movie in a given
 * city and book it.
 * 
 * 
 * Requirement:
 * 
 * 1. Search movie with movie name and Address(city) 2. Book seats 3. Payment
 *
 */
public class Application {

	private ISeatBooking seatBooking;

	public Application() {
		this.seatBooking = new SeatBooking();
	}

	public void clientCode() {

		Thread thread1 = new Thread(() -> {

			Search search = new Search.SearchBuilder("Bangalore", "xyz").setSeatType(SeatType.PREMIUM)
					.setStreet("Banaswadi").build();
			SearchResult result = seatBooking.search(search);
			seatBooking.checkSeatAvaibility(new Theatre(), new Movie(), 2, SeatType.PREMIUM);
			seatBooking.payment(new Theatre(), new Movie(), 2, SeatType.PREMIUM, new User());

		});

		Thread thread2 = new Thread(() -> {
			Search search = new Search.SearchBuilder("Bangalore", "pqr").setSeatType(SeatType.PREMIUM)
					.setStreet("Elements Mall").build();
			SearchResult result = seatBooking.search(search);
			seatBooking.checkSeatAvaibility(new Theatre(), new Movie(), 2, SeatType.EXECUTIVE);
			seatBooking.payment(new Theatre(), new Movie(), 2, SeatType.EXECUTIVE, new User());
		});

		thread1.start();
		thread2.start();
	}

	public static void main(String[] args) {
		new Application().clientCode();
	}
}
