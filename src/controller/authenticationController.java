package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class authenticationController {
    private connector connect = new connector();
    private ResultSet results;

    public void registerUserData(String username, String firstName, String lastName, int age,
                               String phoneNo, String address, String userRole, String userPassword){
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "INSERT INTO userInfo " +
                    "(username, firstName, lastName, age, phoneNo, address, userRole, userPassword) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);

            userStmt.setString(1, username);
            userStmt.setString(2, firstName);
            userStmt.setString(3, lastName);
            userStmt.setInt(4, age);
            userStmt.setString(5, phoneNo);
            userStmt.setString(6, address);
            userStmt.setString(7, userRole);
            userStmt.setString(8, userPassword);

            if(Objects.equals(userRole, "renter")){
                registerRenter(username);
            } else if(Objects.equals(userRole, "landlord")){
                registerLandlord(username);
            } else if(Objects.equals(userRole, "manager")){
                registerManager(username);
            }

            userStmt.executeUpdate();
            userStmt.close();
        } catch (SQLException e){
            System.out.println("Database Error");
        }
    }


    public void registerRenter(String renterUsername){
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "INSERT INTO renterInfo " +
                    "(username) " +
                    "VALUES (?)";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);

            userStmt.setString(1, renterUsername);
            userStmt.executeUpdate();
            userStmt.close();
        } catch (SQLException e){
            System.out.println("Database Error");
        }
    }


    public void registerLandlord(String landlordUsername){
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "INSERT INTO landlordInfo " +
                    "(username) " +
                    "VALUES (?)";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);

            userStmt.setString(1, landlordUsername);
            userStmt.executeUpdate();
            userStmt.close();
        } catch (SQLException e){
            System.out.println("Database Error");
        }
    }

    public void registerManager(String managerUsername){
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "INSERT INTO managerInfo " +
                    "(username) " +
                    "VALUES (?)";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);

            userStmt.setString(1, managerUsername);
            userStmt.executeUpdate();
            userStmt.close();
        } catch (SQLException e){
            System.out.println("Database Error");
        }
    }

    //check if theres a query to find out if the user exists
    public boolean verifyUserData(String username, String password) {
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM userInfo");
            while (results.next()) {
                if (Objects.equals(results.getString("username"), username) &&
                        Objects.equals(results.getString("userPassword"), password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        return false;
    }

    public String getUserType(String username){
        String userType = "";
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM userInfo");
            while (results.next()) {
                if (Objects.equals(results.getString("username"), username)){
                    userType = results.getString("userRole");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        return userType;
    }
}
