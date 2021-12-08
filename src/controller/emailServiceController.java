package controller;

import java.sql.*;
import java.util.Objects;

public class emailServiceController {
    private connector connect = new connector();
    private ResultSet results;

    public void sendTo(int messageID, String receiver, String sender, String message){
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "INSERT INTO emailMessage " +
                    "(messageID, senderUserName, receiverUserName, message) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);

            userStmt.setInt(1, messageID);
            userStmt.setString(2, sender);
            userStmt.setString(2, receiver);
            userStmt.setString(2, message);

            userStmt.executeUpdate();
            userStmt.close();
        } catch (SQLException e){
            System.out.println("Database Error");
        }
    }

    public String getLandlordEmail(String propID){
        String landlordEmail = "";
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM propertyInfo");
            while (results.next()) {
                if (Objects.equals(results.getString("username"), propID)) {
                    landlordEmail = results.getString("landlordUsername");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        return landlordEmail;
    }

    //function to get latest messageID and return it with 1 incremented
    //function to get messages for receiver
    //function to get messages for sender

    //optional:
    //have a table in database of users to notify
    //in the table include username and propertyID (foreign key)
    //whenever property is registered, check through subscribers search criteria's to see if it matches their search criteria
    //if it matches search criteria add to database

    //use sendTo to send email to renters that are in database and have sender be SYSTEM
    //optional idea is to have a popup when the renter logs in
}
