package model.user;

import model.service.Property;

public class RegisteredRenter extends Renter {

	private Property searchCrit;

	public RegisteredRenter(String fname, String lname, int age, String phone,String address,  Role role, String username) {
		super(fname, lname, age, phone,  address,role, username);
	}

	public Property getSearchCrit() {
		return searchCrit;
	}

	public void setSearchCrit(Property searchCrit) {
		this.searchCrit = searchCrit;
	}


}
