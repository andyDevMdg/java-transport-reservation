package org.transportreservation.repository;

import org.transportreservation.model.Bus;
import org.transportreservation.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO implements PaymentInterfaceDAO {
    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Payment payment) {
        String sql = "INSERT INTO payment(payment_method, payment_amount) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, payment.getPayment_method());
            statement.setDouble(2, payment.getPayment_amount());

            statement.executeUpdate();
            System.out.println("Entity inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Payment> getAll() {
        List<Payment> allPayment = new ArrayList<>();
        String sql = "SELECT * FROM payment";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allPayment.add(new Payment(
                        result.getInt("id_payment"),
                        result.getString("payment_method"),
                        result.getDouble("payment_amount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPayment;
    }

    @Override
    public Payment getById(int id) {
        String sql = "SELECT * FROM payment WHERE id_payment = " + id;

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                Payment payment = new Payment(
                        result.getInt("id_payment"),
                        result.getString("payment_method"),
                        result.getDouble("payment_amount")
                );
                return payment;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    @Override
    public Payment updateAmountById(int id, double amount) {
        String sql = "UPDATE payment SET payment_amount = ? WHERE id_payment = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, amount);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getById(id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM payment WHERE id_payment = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
