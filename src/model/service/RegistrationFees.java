package model.service;

import controller.paymentServiceController;

public class RegistrationFees {
	private int fees;
	private static paymentServiceController controller;
	
	public RegistrationFees() {
		controller = new paymentServiceController(); 
	}
	
	public int requestFees(int days) {
		setFees(controller.getFees());
		return 0;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}
}
