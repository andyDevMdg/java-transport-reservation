package org.transportreservation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Class to initialize connection to the database
public class ConnectionDB {
    private static Connection connection;

    private ConnectionDB(){
        try {
            connection = DriverManager.getConnection(
                    Credentials.URL,
                    Credentials.USER,
                    Credentials.PASSWORD
            );
            System.out.println("Connection Successful");
        } catch (SQLException e){
            System.out.println("Error while connecting to the database : " + e.getMessage());
        }
    }

    public static Connection getConnection(){
        if (connection == null){
            new ConnectionDB();
        }
        return connection;
    }

}

