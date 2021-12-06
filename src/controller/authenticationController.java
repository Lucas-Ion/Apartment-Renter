package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class authenticationController {
    private connector connect;
    private ResultSet results;

    public void insertUserData(String username, String firstName, String lastName, int age,
                               String phoneNo, String address, String userRole, String notification, String userPassword){
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "INSERT INTO userInfo " +
                    "(username, firstName, lastName, age, phoneNo, address, userRole, notification, userPassword) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);

            userStmt.setString(1, username);
            userStmt.setString(2, firstName);
            userStmt.setString(3, lastName);
            userStmt.setInt(4, age);
            userStmt.setString(5, phoneNo);
            userStmt.setString(6, address);
            userStmt.setString(7, userRole);
            userStmt.setString(8, notification);
            userStmt.setString(9, userPassword);

            userStmt.executeUpdate();
            userStmt.close();
        } catch (SQLException e){
            System.out.println("Database Error");
        }
    }

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
}
