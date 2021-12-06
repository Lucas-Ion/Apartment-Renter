package model.service;

public class Property {
	private int numOfBed;
	private int numOfBath;
	private boolean isFurnished;
	private String cityQuadrant;
	private String propertyType;
//	private Landlord owner; // landlord class in Hy's parts
	private State propertyState;
	
	public Property(int numBed,int numBath, boolean furnish, String quadrant, String typeProp, State propState/*,Landlord own*/) {
		super();
		numOfBed = numBed;
		numOfBath = numBath;
		isFurnished = furnish;
		cityQuadrant = quadrant;
		propertyType = typeProp;
		// owner = own;
		propertyState = propState;
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

}
