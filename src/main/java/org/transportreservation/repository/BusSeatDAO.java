package org.transportreservation.repository;

import org.springframework.stereotype.Repository;
import org.transportreservation.model.Bus;
import org.transportreservation.model.BusSeat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BusSeatDAO implements BusSeatInterfaceDAO{

    private Connection connection;

    public BusSeatDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void insert(BusSeat busSeat) {
        String sql = "INSERT INTO bus_seat(bus_seat_price, is_taken, id_bus) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, busSeat.getBus_seat_price());
            statement.setBoolean(2, busSeat.getIs_taken());
            statement.setInt(3, busSeat.getId_bus());

            statement.executeUpdate();
            System.out.println("Entity inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BusSeat> getAll() {
        List<BusSeat> allBusSeat = new ArrayList<>();
        String sql = "SELECT * FROM bus_seat";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allBusSeat.add(new BusSeat(
                        result.getInt("id_bus_seat"),
                        result.getDouble("bus_seat_price"),
                        result.getBoolean("is_taken"),
                        result.getInt("id_bus")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allBusSeat;
    }

    @Override
    public BusSeat getById(int id) {
        String sql = "SELECT * FROM bus_seat WHERE id_bus_seat = " + id;

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                BusSeat busSeat = new BusSeat(
                        result.getInt("id_bus_seat"),
                        result.getDouble("bus_seat_price"),
                        result.getBoolean("is_taken"),
                        result.getInt("id_bus")
                );
                return busSeat;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public BusSeat updatePriceById(int id, double price) {
        String sql = "UPDATE bus_seat SET bus_seat_price = ? WHERE id_bus_seat = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, price);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getById(id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM bus_seat WHERE id_bus_seat = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
