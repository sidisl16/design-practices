package com.deisgn.practice.movieticket.booking.system;

public class Search {

	// Mandatory search params
	private String movieName;
	private String city;

	// Optional search params
	private MovieGenere moveiGenere;
	private SeatType seatType;
	private String street;
	private String state;
	private int pin;

	public Search(SearchBuilder builder) {
		this.movieName = builder.movieName;
		this.city = builder.city;
		this.moveiGenere = builder.moveiGenere;
		this.seatType = builder.seatType;
		this.street = builder.street;
		this.state = builder.state;
		this.pin = builder.pin;
	}

	public String getMovieName() {
		return movieName;
	}

	public String getCity() {
		return city;
	}

	public MovieGenere getMoveiGenere() {
		return moveiGenere;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public String getStreet() {
		return street;
	}

	public String getState() {
		return state;
	}

	public int getPin() {
		return pin;
	}

	public static class SearchBuilder {
		// Mandatory search params
		private String movieName;
		private String city;

		// Optional search params
		private MovieGenere moveiGenere;
		private SeatType seatType;
		private String street;
		private String state;
		private int pin;

		public SearchBuilder(String city, String movieName) {
			this.movieName = movieName;
			this.city = city;
		}

		public SearchBuilder setMoveiGenere(MovieGenere moveiGenere) {
			this.moveiGenere = moveiGenere;
			return this;
		}

		public SearchBuilder setSeatType(SeatType seatType) {
			this.seatType = seatType;
			return this;
		}

		public SearchBuilder setStreet(String street) {
			this.street = street;
			return this;
		}

		public SearchBuilder setState(String state) {
			this.state = state;
			return this;
		}

		public SearchBuilder setPin(int pin) {
			this.pin = pin;
			return this;
		}

		public Search build() {
			return new Search(this);
		}
	}
}