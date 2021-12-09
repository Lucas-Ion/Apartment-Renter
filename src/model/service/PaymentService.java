package model.service;

import controller.paymentServiceController;

public class PaymentService {
	private RegistrationFees feeType;
	private String landlordUsername;
	private int days;
	private static paymentServiceController controller;
	
	
	public PaymentService(String landlordUserName) {
		this.feeType = new RegistrationFees();
		controller = new paymentServiceController();
		setLandlordUsername(landlordUserName);
	}
//	public int makePayment(int days) {
//		int feeAmount = feeType.requestFees(days);
//		int myBalance = requestBalance();
//		return myBalance - feeAmount; 
//	}
	
	public String addBalance(int amount) {
		return null;
	}
	
	public void setLandlordUsername(String u) {
		this.landlordUsername = u;
	}
	
//	public int requestBalance() {
//		controller.getBalance(landlordUsername);
//	}
}
