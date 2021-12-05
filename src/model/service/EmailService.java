package model.service;

public class EmailService implements MessageService {
	private String message;
	private Email sender;
	private Email reciever;
	private Property target;
	
	public void processMessage() { // override
		
	}
}
