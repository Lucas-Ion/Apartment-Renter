package model.service;

import java.util.ArrayList;

import controller.emailServiceController;
import controller.listingController;
import controller.propertyController;


public class Listing {
	private ArrayList<String> subscriberList;
	private ArrayList<Property> searchCriteriaList;
	private ArrayList<Property> propertyListing;
	private static listingController listingController;
	private static propertyController propertyController;
	private static emailServiceController emailServiceController;

	public Listing() {
		listingController = new listingController();
		propertyController = new propertyController();
		emailServiceController = new emailServiceController();
		searchCriteriaList = new ArrayList<Property>();
		subscriberList = new ArrayList<String>();
	}

	public void searchMatch(int propId) {
		ArrayList<String> s = propertyController.getProperty(propId);
		String typeProp = s.get(0);
		int numBed = Integer.parseInt(s.get(1));
		int numBath = Integer.parseInt(s.get(2));
		boolean isFurnished = Boolean.parseBoolean(s.get(3));
		String quadrant = s.get(4);
		Property target = new Property(numBed, numBath, isFurnished, quadrant, typeProp);
		requestSubscriberList();

		// search matching
		int counter = 0;
		for (Property p : searchCriteriaList) {
			if (p.compareTo(target) == 1) {
				String message = "Check out Property ID " + propId;
				emailServiceController.sendTo("System", subscriberList.get(counter), message);
			}
			counter++;
		}
	}

	public ArrayList<Property> getPropertyListing() {
		return propertyListing;
	}

	public void setPropertyListing(ArrayList<Property> propertyListing) {
		this.propertyListing = propertyListing;
	}

	public void requestSearchCriteriaList() {

		// Get list of String for search criteria
		ArrayList<String> tmp = new ArrayList<String>();
		for (String s : subscriberList) {
			System.out.println(s);
			tmp.add(listingController.getRenterSearchCriteria(s));
		}

		// Convert to list of Property
		// Assuming that tmp is not null
		for (String s : tmp) {
			String[] eachSC = s.split(" ");
			String typeProp = eachSC[0];
			int numBed = Integer.parseInt(eachSC[1]);
			int numBath = Integer.parseInt(eachSC[2]);
			boolean isFurnished = Boolean.parseBoolean(eachSC[3]);
			String quadrant = eachSC[4];
			searchCriteriaList.add(new Property(numBed, numBath, isFurnished, quadrant, typeProp));
		}
	}

	public void requestSubscriberList() {
		setSubscriberList(listingController.getSubscribers());
		requestSearchCriteriaList();
	}

	public ArrayList<String> getSubscriberList() {
		return subscriberList;
	}

	public void setSubscriberList(ArrayList<String> subscriberList) {
		this.subscriberList = subscriberList;
	}

	public ArrayList<Property> getSearchCriteriaList() {
		return searchCriteriaList;

	}

	public void setSearchCriteriaList(ArrayList<Property> searchCriteriaList) {
		this.searchCriteriaList = searchCriteriaList;
	}

}
