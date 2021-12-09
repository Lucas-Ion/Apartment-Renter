package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import model.service.Property;
import model.user.Renter;

public class propertyController {
    private connector connect;
    private static Renter renterModel = new Renter();
    private ResultSet results;
    
    public propertyController () {
    	connect = new connector();
    }

    //function to get latest propertyID and return it with 1 incremented
    public void registerProperty(int propID, String propState, String propType, int numOfBed,
                               int numOfBath, String isFurnished, String cityQuadrant, String address, int landlordID){
    	
        try{
            Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
                    connect.getUsername(), connect.getPassword());
            String query = "INSERT INTO propertyInfo " +
                    "(propID, propState, propType, numBed, numBath, isFurnished, cityQuadrant, address, landlordID) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement userStmt = dbConnect.prepareStatement(query);

            userStmt.setInt(1, propID);
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
    public String[][] convert2dArray(ArrayList<ArrayList<String>> s) {
        String[][] result = s.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        return result;
    }
    
    //let model handle filtering properties
    public String [][] findProperties(String propType, String numOfBed, String numOfBath, String isFurnished, String cityQuad) {
    	Property tmp = new Property(Integer.parseInt(numOfBed), Integer.parseInt(numOfBath), Boolean.parseBoolean(isFurnished), cityQuad, propType);
    	ArrayList<ArrayList<String>> propertyList = renterModel.searchProperty(tmp);
    	return convert2dArray(propertyList);
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


}
