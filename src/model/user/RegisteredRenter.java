package model.user;

public class RegisteredRenter extends User implements Renter, Observer {

	private Property searchCrit;
	private Subject listing;


	public RegisteredRenter(String name, String address, String phone, Account account, int age, Role role) {
		super(name, address, phone, account, age, role);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateNotification(String[] matchProperties) {
		// TODO Auto-generated method stub
	}

	@Override
	public void searchProperty() {
		// TODO Auto-generated method stub
	}
	
	public void contactOwner(Property p) {}

}
