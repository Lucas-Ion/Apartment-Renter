package model.service;
import java.util.ArrayList;

public class Listing implements Subject {
	private ArrayList<Observer> observerList;
	private ArrayList<Property> propertyListing; // enumeration c++ , pair ,

	
	public void searchMatch() {
		
	}

	public ArrayList<Observer> getObserverList() {
		return observerList;
	}

	public void setObserverList(ArrayList<Observer> observerList) {
		this.observerList = observerList;
	}

	public ArrayList<Property> getPropertyListing() {
		return propertyListing;
	}

	public void setPropertyListing(ArrayList<Property> propertyListing) {
		this.propertyListing = propertyListing;
	}
	
	
}
