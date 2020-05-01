package com.deisgn.practice.parking.lot;

import java.awt.Color;

public class Vehicle {

	// Mandatory params
	private VehicleSize vehicleSize;
	private int numberPlate;

	// optional params
	private String model;
	private Color color;
	private int slotsNeeded;

	public Vehicle(VehicleBuilder builder) {
		this.vehicleSize = builder.vehicleSize;
		this.numberPlate = builder.numberPlate;
		this.model = builder.model;
		this.color = builder.color;
		this.slotsNeeded = builder.slotsNeeded;
	}

	public VehicleSize getVehicleSize() {
		return vehicleSize;
	}

	public int getNumberPlate() {
		return numberPlate;
	}

	public String getModel() {
		return model;
	}

	public Color getColor() {
		return color;
	}

	public int getSlotsNeeded() {
		return slotsNeeded;
	}

	public static class VehicleBuilder {

		// mandatory
		private VehicleSize vehicleSize;
		private int numberPlate;

		// optional
		private String model;
		private Color color;
		private int slotsNeeded;

		public VehicleBuilder(VehicleSize vehicleSize, int numberPlate) {
			this.vehicleSize = vehicleSize;
			this.numberPlate = numberPlate;

			if (vehicleSize == VehicleSize.LARGE) {
				slotsNeeded = 4;
			} else if (vehicleSize == VehicleSize.COMPACT) {
				slotsNeeded = 2;
			} else {
				slotsNeeded = 1;
			}
		}

		public VehicleBuilder setModel(String model) {
			this.model = model;
			return this;
		}

		public VehicleBuilder setColor(Color color) {
			this.color = color;
			return this;
		}

		public Vehicle build() {
			return new Vehicle(this);
		}

	}

}
