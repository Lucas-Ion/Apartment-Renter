package model.user;

import java.util.ArrayList;

import controller.propertyController;
import model.service.Property;

public class Renter extends User {
	private static propertyController controller = new propertyController();

	public Renter(String name, String address, String phone, Account account, int age, Role role) {
		super(name, address, phone, account, age, role);
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
			boolean isFurnished = Integer.parseInt(s.get(5)) == 1 ? true : false;
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
