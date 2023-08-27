package org.transportreservation.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Class to initialize connection to the database
@Configuration
public class ConnectionDB {
    private static Connection connection;
    public ConnectionDB(){
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

    @Bean
    public static Connection getConnection(){
        if (connection == null){
            new ConnectionDB();
        }
        return connection;
    }

}

