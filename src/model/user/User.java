package model.user;

public abstract class User {
	private String fname;
	private String lname;
	private String address;
	private String phone;
	private String notiMessage;
	private Account account; // Account is useless!
	private String username;
	private Role role;
	private int age;

	public User(String fname, String lname, String address, String phone, Account account, int age, Role role) {
		setFName(fname);
		setLName(lname);
		setAddress(address);
		setPhone(phone);
		setAccount(account);
		setAge(age);
		setRole(role);
	}

	public User(String fname, String lname, int age, String phone, String address, Role role, String username) {
		setFName(fname);
		setLName(lname);
		setAddress(address);
		setPhone(phone);
		setUsername(username);
		setAge(age);
		setRole(role);
	}

	public User() {
		setFName("Anonymous");
		setLName("Anonymous");
		setAddress("null");
		setPhone("null");
		setAccount(new Account());
		setAge(0);
		setRole(Role.RENTER);
	}

	public String getFName() {
		return fname;
	}

	public void setFName(String fname) {
		this.fname = fname;
	}

	public String getLName() {
		return lname;
	}

	public void setLName(String lname) {
		this.lname = lname;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
