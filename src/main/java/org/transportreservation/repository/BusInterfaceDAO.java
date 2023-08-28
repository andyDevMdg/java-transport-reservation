package org.transportreservation.repository;

import org.transportreservation.model.Bus;

import java.util.List;

public interface BusInterfaceDAO {
    void insert(Bus bus);

    List<Bus> getAll();

    Bus getById(int id);

    Bus updatePlacesById(int id, String username);

    void deleteById(int id);
}
