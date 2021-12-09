package model.service;

import java.util.ArrayList;

import model.user.Landlord;

public class Property implements Comparable<Property> {
	private int numOfBed;
	private int numOfBath;
	private boolean isFurnished;
	private String cityQuadrant;
	private String propertyType;
	private Landlord owner;
	private State propertyState;

	public Property(int numBed, int numBath, boolean furnish, String quadrant, String typeProp, State propState,
			Landlord own) {
		numOfBed = numBed;
		numOfBath = numBath;
		isFurnished = furnish;
		cityQuadrant = quadrant;
		propertyType = typeProp;
		owner = own;
		propertyState = propState;
	}

	public Property(int numBed, int numBath, boolean furnish, String quadrant, String typeProp) {
		numOfBed = numBed;
		numOfBath = numBath;
		isFurnished = furnish;
		cityQuadrant = quadrant;
		propertyType = typeProp;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public int getNumOfBed() {
		return numOfBed;
	}

	public void setNumOfBed(int numOfBed) {
		this.numOfBed = numOfBed;
	}

	public int getNumOfBath() {
		return numOfBath;
	}

	public void setNumOfBath(int numOfBath) {
		this.numOfBath = numOfBath;
	}

	public boolean isFurnished() {
		return isFurnished;
	}

	public void setFurnished(boolean isFurnished) {
		this.isFurnished = isFurnished;
	}

	public String getCityQuadrant() {
		return cityQuadrant;
	}

	public void setCityQuadrant(String cityQuadrant) {
		this.cityQuadrant = cityQuadrant;
	}

	public State getPropertyState() {
		return propertyState;
	}

	public void setPropertyState(State propertyState) {
		this.propertyState = propertyState;
	}

	@Override
	public int compareTo(Property o) {
		if (this.getCityQuadrant().equals(o.cityQuadrant) && this.getNumOfBath() == o.numOfBath
				&& this.getNumOfBed() == o.numOfBed && this.getPropertyType().equals(o.propertyType)) {
			return 1;
		} else
			return -1;
	}

	@Override
	public String toString() {
		String result = this.propertyType + " " + this.numOfBed + " " + this.numOfBath + " " + this.isFurnished + " "
				+ this.cityQuadrant;
		return result;
	}

	public ArrayList<String> toArray() {
		ArrayList<String> result = new ArrayList<String>();
		result.add(propertyType);
		result.add(String.valueOf(numOfBed));
		result.add(String.valueOf(numOfBath));
		result.add(String.valueOf(isFurnished));
		result.add(cityQuadrant);
		return result;
	}

}
