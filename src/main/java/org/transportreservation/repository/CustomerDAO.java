package org.transportreservation.repository;


import org.springframework.stereotype.Repository;
import org.transportreservation.model.Customer;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDAO implements CustomerInterfaceDAO {
    private Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Customer customer) {
        String sql = "INSERT INTO customer(" +
                "customer_firstname, " +
                "customer_lastname, " +
                "customer_username, " +
                "customer_password, " +
                "customer_address, " +
                "customer_national_id, " +
                "customer_mobile_number, " +
                "customer_registration_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getCustomer_firstname());
            statement.setString(2, customer.getCustomer_lastname());
            statement.setString(3, customer.getCustomer_username());
            statement.setString(4, customer.getCustomer_password());
            statement.setString(5, customer.getCustomer_address());
            statement.setLong(6, customer.getCustomer_national_id());
            statement.setString(7, customer.getCustomer_mobile_number());
            statement.setTimestamp(8, Timestamp.valueOf(customer.getCustomer_registration_date()));
            statement.executeUpdate();
            System.out.println("Entity inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Customer> getAll() {
        List<Customer> allCustomers = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allCustomers.add(new Customer(
                        result.getInt("id_customer"),
                        result.getString("customer_firstname"),
                        result.getString("customer_lastname"),
                        result.getString("customer_username"),
                        result.getString("customer_password"),
                        result.getString("customer_address"),
                        result.getLong("customer_national_id"),
                        result.getString("customer_mobile_number"),
                        result.getTimestamp("customer_registration_date").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }


    @Override
// to find a customer by searching its firstname
    public List<Customer> getByName(String name) {
        List<Customer> allCustomers = new ArrayList<>();
        String sql = "SELECT * FROM customer WHERE customer_firstname LIKE '%" + name + "%'";

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                allCustomers.add(new Customer(
                        result.getInt("id_customer"),
                        result.getString("customer_firstname"),
                        result.getString("customer_lastname"),
                        result.getString("customer_username"),
                        result.getString("customer_password"),
                        result.getString("customer_address"),
                        result.getLong("customer_national_id"),
                        result.getString("customer_mobile_number"),
                        result.getTimestamp("customer_registration_date").toLocalDateTime()
                ));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return allCustomers;
    }


    public Customer getById(int id) {
        String sql = "SELECT * FROM customer WHERE id_customer = " + id;

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                Customer customer = new Customer(
                        result.getInt("id_customer"),
                        result.getString("customer_firstname"),
                        result.getString("customer_lastname"),
                        result.getString("customer_username"),
                        result.getString("customer_password"),
                        result.getString("customer_address"),
                        result.getLong("customer_national_id"),
                        result.getString("customer_mobile_number"),
                        result.getTimestamp("customer_registration_date").toLocalDateTime()
                );
                return customer;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }


    @Override
// Use of Customer as a return value to show the updated table in Postman
    public Customer updateUsernameById(int id, String username) {
        String sql = "UPDATE customer SET customer_username = ? WHERE id_customer = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
// Use of the method getById to show the updated table in Postman
        return getById(id);
    }


    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM customer WHERE id_customer = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
