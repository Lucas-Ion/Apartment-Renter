package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class managerController {
    private connector connect = new connector();
    private ResultSet results;

    public String[][] convert2dArray(ArrayList<ArrayList<String>> s) {
        String[][] result = s.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        return result;
    }

    public String[] convert1dArray(ArrayList<String> s) {
        String[] result = (String[]) s.toArray();
        return result;
    }

    public String[][] getRenterData(){
        ArrayList<ArrayList<String>> renterData = new ArrayList<>();
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM userInfo");
            while(results.next()){
                if(Objects.equals(results.getString("userRole"), "renter")){
                    ArrayList<String> data = new ArrayList<>();
                    data.add(results.getString("firstName"));
                    data.add(results.getString("lastName"));
                    data.add(results.getString("age"));
                    data.add(results.getString("phoneNo"));
                    data.add(results.getString("address"));
                    renterData.add(data);
                }

            }

        } catch (SQLException e){
            System.out.println("Database error");
            e.printStackTrace();
        }
        String[][] result = renterData.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        return result;
    }

    public String[][] getLandlordData(){
        ArrayList<ArrayList<String>> landlordData = new ArrayList<>();
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM userInfo");
            while(results.next()){
                if(Objects.equals(results.getString("userRole"), "landlord")){
                    ArrayList<String> data = new ArrayList<>();
                    data.add(results.getString("firstName"));
                    data.add(results.getString("lastName"));
                    data.add(results.getString("age"));
                    data.add(results.getString("phoneNo"));
                    data.add(results.getString("address"));
                    landlordData.add(data);
                }
            }
        } catch (SQLException e){
            System.out.println("Database error");
            e.printStackTrace();
        }
        String[][] result = landlordData.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        return result;
    }

    public String getUserFullName(String username){
        String userName = "";
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM userInfo");
            while (results.next()) {
                if (Objects.equals(results.getString("username"), username)){
                    userName += results.getString("firstName") + " ";
                    userName += results.getString("lastName");
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        return userName;
    }

    public String getReport(){
        StringBuilder report = new StringBuilder("Periodical Summary Report: \n");
        propertyController property = new propertyController();
        ArrayList<ArrayList<String>> properties = property.getAllProperties();
        ArrayList<ArrayList<String>> rentedHouses = new ArrayList<>();
        int numOfHouses = properties.size();
        int numOfHousesRented = 0;
        int activeListings = 0;

        for (ArrayList<String> strings : properties) {
            if (Objects.equals(strings.get(1), "ACTIVE")) {
                activeListings += 1;
            } else if (Objects.equals(strings.get(1), "RENTED")) {
                numOfHousesRented += 1;
                rentedHouses.add(strings);
            }
        }

        report.append("Total Number of Houses Listed in the Period: ").append(numOfHouses).append("\n");
        report.append("Total Number of Houses Rented in the Period: ").append(numOfHousesRented).append("\n");
        report.append("Total Number of Active Listings: ").append(activeListings).append("\n");
        report.append("List of Houses Rented in the Period: \n");

        for(int i = 1; i < rentedHouses.size()+1; i++){
            report.append(i).append(". ").append("Landlord Name: ").append(getUserFullName(rentedHouses.get(i - 1).get(8)))
                    .append(" Property ID Number: ").append(rentedHouses.get(i - 1).get(0)).append(" Property Address: ").append(rentedHouses.get(i - 1).get(7));
        }

        return report.toString();
    }

    //new function to set fees
    //new function to set period of time
}
