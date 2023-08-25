package org.transportreservation.repository;

import org.transportreservation.model.Customer;

import java.util.List;

public interface CustomerInterfaceDAO {
    void addEntity(Customer customer);

    List<Customer> getAll();

    Customer getById(Long id);

    void updateById(Long id);

    void deleteById(Long id);
}
