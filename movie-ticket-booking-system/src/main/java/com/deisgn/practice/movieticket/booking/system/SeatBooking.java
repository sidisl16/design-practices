package com.deisgn.practice.movieticket.booking.system;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class SeatBooking implements ISeatBooking {

	private PaymentTransaction transaction;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private ReadLock readLock = lock.readLock();
	private WriteLock writeLock = lock.writeLock();

	public SeatBooking() {
		transaction = new PaymentTransaction();
	}

	@Override
	public SearchResult search(Search searchBuilder) {
		readLock.lock();
		// Search logic here
		System.out.println("getting results for you...");
		SearchResult result = new SearchResult();
		readLock.unlock();
		return result;
	}

	// Multiple threads can read
	@Override
	public boolean checkSeatAvaibility(Theatre theatre, Movie movie, int no_of_seat, SeatType seatType) {
		readLock.lock();
		// Checking availability logic here
		System.out.println("Checking avaibility...");
		readLock.unlock();
		return true;
	}

	// Only one thread can book at a time
	@Override
	public Booking payment(Theatre theatre, Movie movie, int no_of_seat, SeatType seatType, User user) {
		writeLock.lock();
		// Payment and booking here, Transaction object
		System.out.println("Redirecting for payment");
		transaction.pay();
		System.out.println("Your booking is confirmed...");
		Booking booking = new Booking();
		writeLock.unlock();
		return booking;
	}

}
