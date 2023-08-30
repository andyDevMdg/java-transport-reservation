package org.transportreservation.repository;

import org.springframework.stereotype.Repository;
import org.transportreservation.model.Booking;
import org.transportreservation.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingDAO implements BookingInterfaceDAO {

    private Connection connection;

    public BookingDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Booking booking) {
        String sql = "INSERT INTO booking(" +
                "departure_location, " +
                "departure_datetime, " +
                "destination_location, " +
                "destination_datetime, " +
                "is_paid, id_customer, " +
                "id_payment, " +
                "id_bus_seat, " +
                "id_employee) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, booking.getDeparture_location());
            statement.setTimestamp(2, Timestamp.valueOf(booking.getDeparture_datetime()));
            statement.setString(3, booking.getDestination_location());
            statement.setTimestamp(4, Timestamp.valueOf(booking.getDestination_datetime()));
            statement.setBoolean(5, booking.getIs_paid());
            statement.setInt(6, booking.getId_customer());
            statement.setInt(7, booking.getId_payment());
            statement.setInt(8, booking.getId_bus_seat());
            statement.setInt(9, booking.getId_employee());
            statement.executeUpdate();
            System.out.println("Entity inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Booking> getAll() {
        List<Booking> allBookings = new ArrayList<>();
        String sql = "SELECT * FROM booking";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allBookings.add(new Booking(
                        result.getInt("id_booking"),
                        result.getString("departure_location"),
                        result.getTimestamp("departure_datetime").toLocalDateTime(),
                        result.getString("destination_location"),
                        result.getTimestamp("destination_datetime").toLocalDateTime(),
                        result.getBoolean("is_paid"),
                        result.getInt("id_customer"),
                        result.getInt("id_payment"),
                        result.getInt("id_bus_seat"),
                        result.getInt("id_employee")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allBookings;
    }

    @Override
    public Booking getById(int id) {
        String sql = "SELECT * FROM booking WHERE id_booking = " + id;

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                Booking booking = new Booking(
                        result.getInt("id_booking"),
                        result.getString("departure_location"),
                        result.getTimestamp("departure_datetime").toLocalDateTime(),
                        result.getString("destination_location"),
                        result.getTimestamp("destination_datetime").toLocalDateTime(),
                        result.getBoolean("is_paid"),
                        result.getInt("id_customer"),
                        result.getInt("id_payment"),
                        result.getInt("id_bus_seat"),
                        result.getInt("id_employee")
                );
                return booking;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public Booking updateDestinationById(int id, String destination) {
        String sql = "UPDATE booking SET destination_location = ? WHERE id_booking = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, destination);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getById(id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM booking WHERE id_booking = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
