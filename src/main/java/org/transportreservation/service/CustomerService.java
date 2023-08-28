package org.transportreservation.service;

import org.springframework.stereotype.Service;
import org.transportreservation.model.Customer;
import org.transportreservation.repository.CustomerDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer insertCustomer(Customer customer) throws SQLException {
        customerDAO.insert(customer);
        return customer;
    }

    public List<Customer> getAll() throws SQLException {
        return customerDAO.getAll();
    }

    public List<Customer> getByName(String username) throws SQLException {
        return customerDAO.getByName(username);
    }

    public Customer getById(int id) throws SQLException {
        return customerDAO.getById(id);
    }

    public Customer updateUsernameById(int id, String username) throws SQLException {
        return customerDAO.updateUsernameById(id, username);
    }

    public void deleteById(int id) throws SQLException {
        customerDAO.deleteById(id);
    }
}
