package model.user;

public class RegularRenter extends User implements Renter {
	
//	private Property searchCrit;


	public RegularRenter(String name, String address, String phone, Account account, int age, Role role) {
		super(name, address, phone, account, age, role);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void searchProperty() {
		// TODO Auto-generated method stub
		
	}

}
