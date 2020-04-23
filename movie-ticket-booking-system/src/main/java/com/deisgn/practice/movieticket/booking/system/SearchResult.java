package com.deisgn.practice.movieticket.booking.system;

import java.util.List;

public class SearchResult {

	private List<Theatre> theaters;
	private Movie movie;

	public List<Theatre> getTheaters() {
		return theaters;
	}

	public void setTheaters(List<Theatre> theaters) {
		this.theaters = theaters;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}