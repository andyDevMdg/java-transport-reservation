package org.transportreservation.repository;

import org.transportreservation.model.Bus;
import org.transportreservation.model.Customer;
import org.transportreservation.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO implements BusInterfaceDAO {
    private Connection connection;

    public BusDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Bus bus) {
        String sql = "INSERT INTO bus(bus_plate_number, bus_number_of_places, bus_brand) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bus.getBus_plate_number());
            statement.setInt(2, bus.getBus_number_of_places());
            statement.setString(3, bus.getBus_brand());

            statement.executeUpdate();
            System.out.println("Entity inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bus> getAll() {
        List<Bus> allBus = new ArrayList<>();
        String sql = "SELECT * FROM bus";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allBus.add(new Bus(
                        result.getInt("id_employee"),
                        result.getString("bus_plate_number"),
                        result.getInt("bus_number_of_places"),
                        result.getString("bus_brand")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allBus;
    }

    @Override
    public Bus getById(int id) {
        String sql = "SELECT * FROM bus WHERE id_bus = " + id;

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                Bus bus = new Bus(
                        result.getInt("id_bus"),
                        result.getString("bus_plate_number"),
                        result.getInt("bus_number_of_places"),
                        result.getString("bus_brand")
                );
                return bus;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public Bus updatePlacesById(int id, int numberOfPlaces) {
        String sql = "UPDATE bus SET bus_number_of_places = ? WHERE id_bus = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, numberOfPlaces);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getById(id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM bus WHERE id_bus = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
