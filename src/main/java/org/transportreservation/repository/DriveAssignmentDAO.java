package org.transportreservation.repository;

import org.springframework.stereotype.Repository;
import org.transportreservation.model.DriveAssignment;
import org.transportreservation.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DriveAssignmentDAO implements DriveAssignmentInterfaceDAO {

    private Connection connection;

    public DriveAssignmentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(DriveAssignment driveAssignment) {
        String sql = "INSERT INTO drive_assignment(id_bus, id_drive) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, driveAssignment.getId_bus());
            statement.setInt(2, driveAssignment.getId_drive());

            statement.executeUpdate();
            System.out.println("Entity inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DriveAssignment> getAll() {
        List<DriveAssignment> allDriveAssignment = new ArrayList<>();
        String sql = "SELECT * FROM drive_assignment";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allDriveAssignment.add(new DriveAssignment(
                        result.getInt("id_drive_assignment"),
                        result.getInt("id_bus"),
                        result.getInt("id_drive")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDriveAssignment;
    }

    @Override
    public DriveAssignment getById(int id) {
        String sql = "SELECT * FROM drive_assignment WHERE id_drive_assignment = " + id;

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                DriveAssignment driveAssignment = new DriveAssignment(
                        result.getInt("id_drive_assignment"),
                        result.getInt("id_bus"),
                        result.getInt("id_drive")
                );
                return driveAssignment;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public DriveAssignment updateDriverById(int id, int driver) {
        String sql = "UPDATE drive_assignment SET id_drive = ? WHERE id_drive_assignment = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, driver);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getById(id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM drive_assignment WHERE id_drive_assignment = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
