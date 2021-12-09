package model.service;

import controller.paymentServiceController;

public class PaymentService {
	private String landlordUsername;
	private int days;
	private int fees;
	private static paymentServiceController controller;


	public PaymentService(String username) {
		controller = new paymentServiceController();
		setLandlordUsername(username);
	}

	public int makePayment(int days) {
		requestFees(days);
		int myBalance = requestBalance();
		return myBalance - fees;
	}

	public void addBalance(int amount) {
		int balance = controller.getBalance(landlordUsername);
		controller.updateBalance(landlordUsername, amount + balance);
	}
	
	public void updateBalance(int amount) {
		controller.updateBalance(landlordUsername, amount);
	}
	
	public int requestBalance() {
		return controller.getBalance(landlordUsername);
	}

	public void setLandlordUsername(String u) {
		this.landlordUsername = u;
	}

	public void requestFees(int days) {
		setFees(controller.getFees());
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}


}
