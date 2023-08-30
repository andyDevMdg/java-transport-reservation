package org.transportreservation.repository;

import org.springframework.stereotype.Repository;
import org.transportreservation.model.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverDAO implements DriverInterfaceDAO{
    private Connection connection;

    public DriverDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Driver driver) {
        String sql = "INSERT INTO driver(" +
                "driver_firstname, " +
                "driver_lastname, " +
                "driver_address, " +
                "driver_national_id, " +
                "driver_mobile_number) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, driver.getDriver_firstname());
            statement.setString(2, driver.getDriver_lastname());
            statement.setString(3, driver.getDriver_address());
            statement.setDouble(4, driver.getDriver_national_id());
            statement.setString(5, driver.getDriver_mobile_number());

            statement.executeUpdate();
            System.out.println("Entity inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();
        String sql = "SELECT * FROM driver";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allDrivers.add(new Driver(
                        result.getInt("id_driver"),
                        result.getString("driver_firstname"),
                        result.getString("driver_lastname"),
                        result.getString("driver_address"),
                        result.getDouble("driver_national_id"),
                        result.getString("driver_mobile_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDrivers;
    }

    @Override
    public List<Driver> getByName(String name) {
        List<Driver> allDrivers = new ArrayList<>();
        String sql = "SELECT * FROM driver WHERE driver_firstname LIKE '%" + name + "%'";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allDrivers.add(new Driver(
                        result.getInt("id_driver"),
                        result.getString("driver_firstname"),
                        result.getString("driver_lastname"),
                        result.getString("driver_address"),
                        result.getDouble("driver_national_id"),
                        result.getString("driver_mobile_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDrivers;
    }

    @Override
    public Driver getById(int id) {
        String sql = "SELECT * FROM driver WHERE id_driver = " + id;

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                Driver driver = new Driver(
                        result.getInt("id_driver"),
                        result.getString("driver_firstname"),
                        result.getString("driver_lastname"),
                        result.getString("driver_address"),
                        result.getDouble("driver_national_id"),
                        result.getString("driver_mobile_number")
                );
                return driver;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public Driver updatePhoneById(int id, String phone) {
        String sql = "UPDATE driver SET driver_mobile_number = ? WHERE id_driver = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, phone);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getById(id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM driver WHERE id_driver = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
