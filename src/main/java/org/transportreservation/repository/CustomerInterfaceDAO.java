package org.transportreservation.repository;

import org.transportreservation.model.Customer;

import java.util.List;

public interface CustomerInterfaceDAO {
    void addCustomer(Customer c);

    List<Customer> getAllCustomer();
    List<Customer> getCustomerbyId(int id);

    void updateCustomerById(int id);

    void deleteCustomerById(int id);
}
