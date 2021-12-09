package model.user;

import java.util.ArrayList;

import model.service.PaymentService;
import model.service.Property;

//import java.util.ArrayList;

public class Landlord extends User {
	
	private ArrayList <Property> propertyList;
//	private ArrayList <RegFees> publishedList; 
	private PaymentService paymentService; 
	

	public Landlord(String name, String address, String phone, Account account, int age, Role role) {
		super(name, address, phone, account, age, role);
//		paymentService = new PaymentService();
		// TODO Auto-generated constructor stub
	}
	
	
//	public void registerProperty(Property p) {}
//	public void updateProperty(Property newP) {}
//	public int makePayment(int days) {
//		return paymentService.makePayment(days);
//	}
	public void changePropertyState() {
		
	}
//	public void publishProperty(Property p) {}
	
}
