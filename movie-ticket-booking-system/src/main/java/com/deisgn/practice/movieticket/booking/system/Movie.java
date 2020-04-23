package com.deisgn.practice.movieticket.booking.system;

public class Movie {

	private int movieId;
	private String name;
	private MovieGenere movieGenere;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MovieGenere getMovieGenere() {
		return movieGenere;
	}

	public void setMovieGenere(MovieGenere movieGenere) {
		this.movieGenere = movieGenere;
	}

}
