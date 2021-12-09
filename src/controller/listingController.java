package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class listingController {
    private connector connect = new connector();
    private ResultSet results;

    public ArrayList<String> getSubscribers(){
        ArrayList<String> subscriberList = new ArrayList<>();
        managerController userGetter = new managerController();
        ArrayList<ArrayList<String>> userInfo = new ArrayList<>();

        for (ArrayList<String> strings : userInfo) {
            if (!strings.get(1).isEmpty()) {
                subscriberList.add(strings.get(0));
            }
        }
        return subscriberList;
    }

    public String getRenterSearchCriteria(String renterUsername){
        String renterSearchCrit = "";
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM renterInfo");
            while (results.next()) {
                if (Objects.equals(results.getString("username"), renterUsername)) {
                    renterSearchCrit = results.getString("searchCrit");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }

        return renterSearchCrit;
    }

    public void setRenterSearchCriteria(String renterUsername, String searchCriteria){
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "UPDATE renterInfo SET searchCrit=? WHERE username=?";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);
            userStmt.setString(1, searchCriteria);
            userStmt.setString(2, renterUsername);
            userStmt.executeUpdate();
            userStmt.close();
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
    }
}
