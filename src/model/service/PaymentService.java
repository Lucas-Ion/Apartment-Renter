package model.service;

public class PaymentService {
	public RegistrationFees feeType;
	
	public PaymentService(RegistrationFees feeType) {
		super();
		this.feeType = feeType;
	}
	public String makePayment() {
		return null;
	}
	
	public String addBalance(int amount) {
		return null;
	}
	
	public int checkBalance() {
		return 0;
	}
}
