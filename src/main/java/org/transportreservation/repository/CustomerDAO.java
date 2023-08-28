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

    }

    @Override
    public List<Customer> getAll() {
        List<Customer> allCustomers = new ArrayList<>();

        return allCustomers;
    }

    @Override
// to find a customer ny searching its firstname
    public List<Customer> getByName(String name) {
        List<Customer> allCustomers = new ArrayList<>();

        return allCustomers;
    }

    public Customer getById(int id) {

        return null;
    }


    @Override

    public Customer updateUsernameById(int id, String username) {
        return null;
    }


    @Override
    public void deleteById(int id) {

    }

}
