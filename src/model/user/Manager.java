package model.user;

import java.util.ArrayList;

public class Manager extends User {
	public Manager(String name, String address, String phone, Account account, int age, Role role) {
		super(name, address, phone, account, age, role);
		// TODO Auto-generated constructor stub
	}


	private ArrayList<RegisteredRenter> regRenterList;
	private ArrayList<Landlord> landlordList;
	



	public ArrayList<RegisteredRenter> getRegRenterList() {
		return regRenterList;
	}

	public void setRegRenterList(ArrayList<RegisteredRenter> regRenterList) {
		this.regRenterList = regRenterList;
	}


	public ArrayList<Landlord> getLandlordList() {
		return landlordList;
	}


	public void setLandlordList(ArrayList<Landlord> landlordList) {
		this.landlordList = landlordList;
	}
	
	

}
