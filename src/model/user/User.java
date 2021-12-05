package model.user;

public abstract class User {
	private String name;
	private String address;
	private String phone;
	private String notiMessage;
	private Account account;
	private Role role;
	private int age;

	public User(String name, String address, String phone, Account account, int age, Role role) {
		setName(name);
		setAddress(address);
		setPhone(phone);
		setAccount(account);
		setAge(age);
		setRole(role);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotiMessage() {
		return notiMessage;
	}

	public void setNotiMessage(String notiMessage) {
		this.notiMessage = notiMessage;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		try {
			this.account = (Account) account.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
