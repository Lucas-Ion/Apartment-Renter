package controller;

import java.sql.*;
import java.util.Objects;

public class paymentServiceController {
    private connector connect = new connector();
    private ResultSet results;

    public int getBalance(int landlordID) {
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM landlordInfo");
            while (results.next()) {
                if (results.getInt("landlordID") == landlordID){
                    return results.getInt("lanlordID");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        return -1;
    }

    public void updateBalance(int landlordID, int amount){
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "UPDATE landlordInfo SET balance=? WHERE landlordID=?";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);
            userStmt.setInt(1, amount);
            userStmt.setInt(2, landlordID);
            userStmt.executeUpdate();
            userStmt.close();
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
    }

    public int getFees(){
        int fee = 0;
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM fees");
            while (results.next()) {
                fee = results.getInt("fee");
            }

        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        return fee;
    }

    public int getPeriod(){
        int period = 0;
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM fees");
            while (results.next()) {
                period = results.getInt("period");
            }

        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        return period;
    }

}
