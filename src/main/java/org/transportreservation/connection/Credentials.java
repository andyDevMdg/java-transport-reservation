package org.transportreservation.connection;

public class Credentials {
    public static final String URL = "jdbc:postgresql://localhost/transport_reservation";
    public static final String USER = System.getenv("PSQL_USER");
    public static final String PASSWORD = System.getenv("PSQL_PASSWORD");
}
