package com.deisgn.practice.parking.lot;

import java.util.ArrayList;
import java.util.List;

public class Row {
	
	private int rowNo;
	private int levelNo;
	private List<Slot> slots;
	
	public Row(int rowNo, int levelNo) {
		this.rowNo = rowNo;
		this.levelNo = levelNo;
		this.slots = new ArrayList<>();
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}

	public List<Slot> getSlots() {
		return slots;
	}
}
