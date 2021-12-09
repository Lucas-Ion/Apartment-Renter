package model.user;

import java.util.ArrayList;

import controller.propertyController;
import model.service.Property;

public class Renter extends User {
	private static propertyController controller = new propertyController();

	public Renter(String fname, String lname, String address, String phone, Account account, int age, Role role) {
		super(fname, lname, address, phone, account, age, role);
		// TODO Auto-generated constructor stub
	}
	
	public Renter(String fname, String lname, int age, String phone,String address,  Role role, String username) {
		super(fname, lname, age, phone,  address,role, username);
	}

	public Renter() {
		super();
	}

	public ArrayList<ArrayList<String>> searchProperty(Property p) {
		ArrayList<ArrayList<String>> tmp = controller.getAllProperties();
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for (ArrayList<String> s : tmp) {
			int numBath = Integer.parseInt(s.get(4));
			int numBed = Integer.parseInt(s.get(3));
			boolean isFurnished = Boolean.parseBoolean(s.get(5));
			String quadrant = s.get(6);
			String typeProp = s.get(2);
			Property prop = new Property(numBed, numBath, isFurnished, quadrant, typeProp);
			if (p.compareTo(prop) == 1) {
				result.add(prop.toArray());
			}
		}
		return result;
	}
}
