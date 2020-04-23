package com.deisgn.practice.movieticket.booking.system;

public interface ISeatBooking {

	public SearchResult search(Search searchBuilder);

	public abstract boolean checkSeatAvaibility(Theatre theatre, Movie movie, int no_of_seat, SeatType seatType);

	public abstract Booking payment(Theatre theatre, Movie movie, int no_of_seat, SeatType seatType, User user);

}
