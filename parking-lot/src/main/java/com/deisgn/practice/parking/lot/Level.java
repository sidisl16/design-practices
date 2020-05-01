package com.deisgn.practice.parking.lot;

import java.util.ArrayList;
import java.util.List;

public class Level {

	private int levelNo;
	private ParkingLot parkingLot;
	List<Row> rows;

	// Composition
	public Level(ParkingLot parkingLot, int levelNo) {
		if (parkingLot == null) {
			throw new IllegalArgumentException("parking lot cannot be null");
		}
		this.parkingLot = parkingLot;
		this.levelNo = levelNo;
		rows = new ArrayList<>();
	}

	public int getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		if (parkingLot == null) {
			throw new IllegalArgumentException("parking lot cannot be null");
		}
		this.parkingLot = parkingLot;
	}

	public List<Row> getRows() {
		return rows;
	}

}
