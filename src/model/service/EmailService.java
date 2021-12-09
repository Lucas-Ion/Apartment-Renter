package model.service;

public class EmailService implements MessageService {
	private String message;
	private String sender;
	private String receiver;
	private Property target;
	
	public EmailService(String message, String sender, String receiver, Property target) {
		this.message = message;
		this.sender = sender;
		this.receiver = receiver;
		this.target = target;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Property getTarget() {
		return target;
	}

	public void setTarget(Property target) {
		this.target = target;
	}

	@Override
	public void processMessage() {
		
	}

}
