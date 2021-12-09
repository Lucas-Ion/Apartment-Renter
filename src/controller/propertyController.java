package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class propertyController {
    private connector connect = new connector();
    private ResultSet results;

    public void registerProperty(String propState, String propType, int numOfBed,
                               int numOfBath, String isFurnished, String cityQuadrant, String address, int landlordID){
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "INSERT INTO propertyInfo " +
                    "(propID, propState, propType, numBed, numBath, isFurnished, cityQuadrant, address, landlordID) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
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
        } catch (SQLException e){
            System.out.println("Database Error");
        }
    }

    //let model handle filtering properties
    public ArrayList<ArrayList<String>> findProperties(String propType, String numOfBed, String numOfBath, String isFurnished, String cityQuad) {
        StringBuilder property = new StringBuilder();
        ArrayList<ArrayList<String>> propertyList = new ArrayList<>();
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM propertyInfo");
            while (results.next()) {
                property.append(results.getString("propType")).append(" ").append(results.getString("numBed")).append(" ")
                        .append(results.getString("numBath")).append(" ").append(results.getString("isFurnished")).append(" ")
                        .append(results.getString("cityQuadrant"));
                String propInfo = property.toString();
                if(propInfo.contains(propType) && propInfo.contains(numOfBed) && propInfo.contains(numOfBath) && propInfo.contains(isFurnished)
                && propInfo.contains(cityQuad)){
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(results.getString("propID"));
                    temp.add(results.getString("propType"));
                    temp.add(results.getString("numBed"));
                    temp.add(results.getString("numBath"));
                    temp.add(results.getString("isFurnished"));
                    temp.add(results.getString("cityQuadrant"));
                    propertyList.add(temp);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        return propertyList;
    }

    public void changePropertyState(String propID, String propState){
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "UPDATE propertyInfo SET propState=? WHERE propID=?";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);
            userStmt.setString(1, propState);
            userStmt.setString(2, propID);
            userStmt.executeUpdate();
            userStmt.close();
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<String>> getAllProperties(){
        ArrayList<ArrayList<String>> propertyInfo = new ArrayList<>();
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM propertyInfo");
            while(results.next()){
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

        } catch (SQLException e){
            System.out.println("Database error");
            e.printStackTrace();
        }
        return propertyInfo;
    }

    public int getLatestPropertyID(){
        int propertyID = 0;
        try {
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM propertyInfo");
            while (results.next()) {
                propertyID = results.getInt("propID");
            }
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
        return propertyID+1;
    }

}
