package model.user;

import model.service.Observer;
import model.service.Property;
import model.service.Subject;

public class RegisteredRenter extends Renter implements Observer {

	private Property searchCrit;
	private Subject listing;

	public RegisteredRenter(String name, String address, String phone, Account account, int age, Role role) {
		super(name, address, phone, account, age, role);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateNotification(String[] matchProperties) {
		// TODO Auto-generated method stub
	}
	
	public void contactOwner(Property p) {}

	public Property getSearchCrit() {
		return searchCrit;
	}

	public void setSearchCrit(Property searchCrit) {
		this.searchCrit = searchCrit;
	}

	public Subject getListing() {
		return listing;
	}

	public void setListing(Subject listing) {
		this.listing = listing;
	}

}
