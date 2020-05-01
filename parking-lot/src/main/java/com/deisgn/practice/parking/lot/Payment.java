package com.deisgn.practice.parking.lot;

import java.util.UUID;

public class Payment {

	private String bookingId;
	private String transactionId;
	private PaymentStatus paymentStatus;
	private PaymentMode paymentMode;

	public Payment(String bookingId, PaymentStatus paymentStatus, PaymentMode paymentMode) {
		this.bookingId = bookingId;
		this.transactionId = UUID.randomUUID().toString();
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

}
