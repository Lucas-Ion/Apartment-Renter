package model.user;

public class Account implements Cloneable {
	private String username;
	private String password;
	
	public Account(String u, String p) {
		this.setUsername(u);
		this.setPassword(p);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
