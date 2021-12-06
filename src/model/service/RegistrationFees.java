package model.service;

public class RegistrationFees {
	private int fees;
	
	public RegistrationFees(int fees) {
		this.fees = fees;
	}
	
	public void feesCalculation(int days) {
		// weeks or months
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}
}
