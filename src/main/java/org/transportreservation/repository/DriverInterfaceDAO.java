package org.transportreservation.repository;

import org.transportreservation.model.Driver;

import java.util.List;

public interface DriverInterfaceDAO {
    void insert(Driver driver);

    List<Driver> getAll();

    List<Driver> getByName(String name);

    Driver getById(int id);

    Driver updatePhoneById(int id, String phone);

    void deleteById(int id);
}
