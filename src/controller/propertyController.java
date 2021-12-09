package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import model.service.Listing;
import model.service.PaymentService;
import model.service.Property;
import model.user.Landlord;
import model.user.Renter;

public class propertyController {
	private connector connect = new connector();
	private Renter renterModel = new Renter();
	private PaymentService paymentService;
	private static Listing listingModel = new Listing();
	private ResultSet results;

	public String[][] convert2dArray(ArrayList<ArrayList<String>> s) {
		String[][] result = s.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
		return result;
	}

	public void registerProperty(String propState, String propType, int numOfBed, int numOfBath, String isFurnished,
			String cityQuadrant, String address, int landlordID) {
		try {
			Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(), connect.getUsername(),
					connect.getPassword());
			String query = "INSERT INTO propertyInfo "
					+ "(propID, propState, propType, numBed, numBath, isFurnished, cityQuadrant, address, landlordID) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement userStmt = dbConnect.prepareStatement(query);

			userStmt.setInt(1, getLatestPropertyID());
			userStmt.setString(2, propState);
			userStmt.setString(3, propType);
			userStmt.setInt(4, numOfBed);
			userStmt.setInt(5, numOfBath);
			userStmt.setString(6, isFurnished);
			userStmt.setString(7, cityQuadrant);
			userStmt.setString(8, address);
			userStmt.setInt(9, landlordID);

			userStmt.executeUpdate();
			userStmt.close();
		} catch (SQLException e) {
			System.out.println("Database Error");
		}
	}

	public ArrayList<String> getUserData(String username) {
		ArrayList<String> userData = new ArrayList<>();
		try {
			Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(), connect.getUsername(),
					connect.getPassword());
			Statement myStmt = dbConnect.createStatement();
			results = myStmt.executeQuery("SELECT * FROM userInfo");
			while (results.next()) {
				if (Objects.equals(results.getString("username"), username)) {
					userData.add(results.getString("firstName"));
					userData.add(results.getString("lastName"));
					userData.add(results.getString("age"));
					userData.add(results.getString("phoneNo"));
					userData.add(results.getString("address"));
					userData.add(results.getString("userRole"));
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return userData;
	}

	public String[][] findProperties(String propType, String numOfBed, String numOfBath, String isFurnished,
			String cityQuad) {
		Property tmp = new Property(Integer.parseInt(numOfBed), Integer.parseInt(numOfBath),
				Boolean.parseBoolean(isFurnished), cityQuad, propType);
		ArrayList<ArrayList<String>> propertyList = renterModel.searchProperty(tmp);
		return convert2dArray(propertyList);
	}

	public void changePropertyState(String propID, String propState) {
		try {
			Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(), connect.getUsername(),
					connect.getPassword());
			String query = "UPDATE propertyInfo SET propState=? WHERE propID=?";
			PreparedStatement userStmt = dbConnect.prepareStatement(query);
			userStmt.setString(1, propState);
			userStmt.setString(2, propID);
			userStmt.executeUpdate();
			userStmt.close();

			if (propState == "ACTIVE") {
				listingModel.searchMatch(Integer.parseInt(propID));
			}
		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
	}

	public String publishProperty(String propId, int days, String username) {
		paymentService = new PaymentService(username);
		// Balance is sufficient
		int remainingBalance = paymentService.makePayment(days);
		if (remainingBalance >= 0) {
			paymentService.updateBalance(remainingBalance);
			changePropertyState(propId, "ACTIVE");
			return "Your property has been published! Your balance has "+ remainingBalance;
		}
		// Balance is not sufficient
		else {
			return "Your balance is not sufficient for publishing";
		}

	}

	public ArrayList<String> getProperty(int propID) {
		ArrayList<String> property = new ArrayList<>();
		try {
			Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(), connect.getUsername(),
					connect.getPassword());
			Statement myStmt = dbConnect.createStatement();
			results = myStmt.executeQuery("SELECT * FROM propertyInfo");
			while (results.next()) {
				if (Objects.equals(results.getInt("propID"), propID)) {
					property.add(results.getString("propType"));
					property.add(String.valueOf(results.getInt("numBed")));
					property.add(String.valueOf(results.getInt("numBath")));
					property.add(results.getString("isFurnished"));
					property.add(results.getString("cityQuadrant"));
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return property;
	}

	public ArrayList<ArrayList<String>> getAllProperties() {
		ArrayList<ArrayList<String>> propertyInfo = new ArrayList<>();
		try {
			Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(), connect.getUsername(),
					connect.getPassword());
			Statement myStmt = dbConnect.createStatement();
			results = myStmt.executeQuery("SELECT * FROM propertyInfo");
			while (results.next()) {
				ArrayList<String> data = new ArrayList<>();
				data.add(String.valueOf(results.getInt("propID")));
				data.add(results.getString("propState"));
				data.add(results.getString("propType"));
				data.add(String.valueOf(results.getInt("numBed")));
				data.add(String.valueOf(results.getInt("numBath")));
				data.add(results.getString("isFurnished"));
				data.add(results.getString("cityQuadrant"));
				data.add(results.getString("address"));
				data.add(results.getString("landlordUsername"));
				propertyInfo.add(data);
			}

		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return propertyInfo;
	}

	public int getLatestPropertyID() {
		int propertyID = 0;
		try {
			Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(), connect.getUsername(),
					connect.getPassword());
			Statement myStmt = dbConnect.createStatement();
			results = myStmt.executeQuery("SELECT * FROM propertyInfo");
			while (results.next()) {
				propertyID = results.getInt("propID");
			}
		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return propertyID + 1;
	}

}
