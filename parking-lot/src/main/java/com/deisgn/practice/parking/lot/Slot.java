package com.deisgn.practice.parking.lot;

public class Slot {

	private int rowNo;
	private int slotNo;
	private boolean isOccupied;

	public Slot(int rowNo, int slotNo) {
		this.rowNo = rowNo;
		this.slotNo = slotNo;
		this.isOccupied = false;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public int getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
}
