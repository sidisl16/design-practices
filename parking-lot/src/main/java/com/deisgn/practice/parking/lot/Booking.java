package com.deisgn.practice.parking.lot;

import java.util.List;
import java.util.UUID;

public class Booking implements IBooking {

	private String bookingId;
	private Vehicle vehicle;
	private int levelNo;
	private int rowNo;
	private List<Slot> slots;
	private long vehicleInTime;

	private long vehicleOutTime;
	private Payment payment;

	public Booking(BookingBuilder bookingBuilder) {
		this.bookingId = bookingBuilder.bookingId;
		this.vehicle = bookingBuilder.vehicle;
		this.levelNo = bookingBuilder.levelNo;
		this.rowNo = bookingBuilder.rowNo;
		this.slots = bookingBuilder.slots;
		this.vehicleInTime = bookingBuilder.vehicleInTime;
	}

	public long getVehicleOutTime() {
		return vehicleOutTime;
	}

	public void setVehicleOutTime(long vehicleOutTime) {
		this.vehicleOutTime = vehicleOutTime;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String getBookingId() {
		return bookingId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public int getRowNo() {
		return rowNo;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public long getVehicleInTime() {
		return vehicleInTime;
	}

	public static class BookingBuilder {

		private String bookingId;
		private Vehicle vehicle;
		private int levelNo;
		private int rowNo;
		private List<Slot> slots;
		private long vehicleInTime;

		public BookingBuilder setVehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
			return this;
		}

		public BookingBuilder setLevelNo(int levelNo) {
			this.levelNo = levelNo;
			return this;
		}

		public BookingBuilder setRowNo(int rowNo) {
			this.rowNo = rowNo;
			return this;
		}

		public BookingBuilder setSlots(List<Slot> slots) {
			this.slots = slots;
			return this;
		}

		public Booking build() {
/**
			if (vehicle == null) {
				throw new IllegalArgumentException("Vehicle cannot be null.");
			}

			if (slots == null || (slots != null && slots.isEmpty())) {
				throw new IllegalArgumentException("Slots cannot be empty.");
			}

**/			this.bookingId = UUID.randomUUID().toString();
			this.vehicleInTime = System.currentTimeMillis();

			return new Booking(this);
		}

	}

}
