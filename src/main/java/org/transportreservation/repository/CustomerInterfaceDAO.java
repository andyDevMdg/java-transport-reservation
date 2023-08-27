package org.transportreservation.repository;

import org.transportreservation.model.Customer;

import java.util.List;

public interface CustomerInterfaceDAO {
    void insert(Customer customer);

    List<Customer> getAll();

    List<Customer> getByName(String name);

    Customer getById(Long id);

    Customer updateUsernameById(int id, String username);

    void deleteById(Long id);
}
