package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class connector {
    private Connection dbConnect;
    private ResultSet results;

    private String dbUrl;
    private String username;
    private String password;

    /**
     * Constructor for DatabaseIO in the case that no username
     * or password has been entered.
     */
    public connector() {
        this.dbUrl = "jdbc:mysql://localhost:3306/propertySystem";
        this.username = "root";
        this.password = "NMN[L0v31sS3x]";
    }

    /**
     * Constructor for DatabaseIO in the case that the user has inputted
     * their username and password.
     * The DatabaseIO object can be constructed using the given data.
     *
     * @param username String username is the user-entered variable of
     *                 their username
     * @param password String password is the user-entered variable of
     *                 their password
     */
    public connector(String username, String password) {
        this.dbUrl = "jdbc:mysql://localhost/propertySystem";
        this.username = username;
        this.password = password;
    }

    /**
     * Getter method for the database URL
     *
     * @return string of database URL
     */
    public String getDbUrl() {
        return dbUrl;
    }

    /**
     * Getter method for the users mySQL username
     *
     * @return string of mySQL username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter method for the users mySQL password
     *
     * @return string of mySQL password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method sets the mySQL username
     *
     * @param username String variable of mySQL username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter method sets the mySQL password
     *
     * @param password String variable of mySQL password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method for updating MySQL credentials. Will close current connection,
     * save the parameters as the new credentials, and attempt to open
     * a new connection using the updated credentials.
     *
     * @param dbUrl    New database URL
     * @param username New database username
     * @param password New database password
     */
    public void updateCredentials(String dbUrl, String username,
                                  String password) {
        try {
            if (this.dbConnect != null) {
                dbConnect.close();
            }
            this.dbUrl = dbUrl;
            this.username = username;
            this.password = password;
        } catch (SQLException e) {
            System.out.println("Could not update MySQL credentials");
        }
    }

    /**
     * The method initializeConnection promises to create a
     * connection to the database otherwise it will output an error.
     */
    public boolean createConnection() {
        try {
            this.dbConnect = DriverManager.getConnection(this.dbUrl,
                    this.username, this.password);
            return true;
        } catch (SQLException e) {
            System.out.println();
            System.out.println("Unable to create a connection with");
            System.out.println("the credentials:");
            System.out.println("     DbURL: " + this.dbUrl);
            System.out.println("  Username: " + this.username);
            StringBuilder hiddenPassword = new StringBuilder();
            hiddenPassword.append("*".repeat(this.password.length()));
            System.out.println("  Password: " + hiddenPassword.toString());
            System.out.println();
            return false;
        }
    }

    /**
     * The method close promises to close the database connection.
     */
    public void close(){
        try{
            dbConnect.close();
            results.close();
        } catch (SQLException e){
            System.out.println("Unable to close the connection");
            e.printStackTrace();
        }
    }
}
