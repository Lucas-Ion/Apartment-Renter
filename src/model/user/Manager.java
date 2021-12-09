package model.user;

import java.util.ArrayList;

public class Manager extends User {
	public Manager(String fname, String lname, String address, String phone, Account account, int age, Role role) {
		super(fname, lname, address, phone, account, age, role);
		// TODO Auto-generated constructor stub
	}

	public Manager(String fname, String lname, int age, String phone, String address, Role role, String username) {
		super(fname, lname, age, phone, address, role, username);
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
