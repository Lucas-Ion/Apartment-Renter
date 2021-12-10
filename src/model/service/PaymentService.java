package model.service;

import controller.paymentServiceController;

public class PaymentService {
	private final int BASE_DAY = 30;
	private String landlordUsername;
	private static paymentServiceController controller;

	public PaymentService(String username) {
		controller = new paymentServiceController();
		setLandlordUsername(username);
	}

	public int makePayment(int days) {
		int fees = requestFees() * days/BASE_DAY;
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

	public int requestFees() {
		return controller.getFees();
	}


}
