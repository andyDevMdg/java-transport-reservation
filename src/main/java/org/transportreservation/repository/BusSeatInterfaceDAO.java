package org.transportreservation.repository;

import org.transportreservation.model.BusSeat;

import java.util.List;

public interface BusSeatInterfaceDAO {
    void insert(BusSeat bus);

    List<BusSeat> getAll();

    BusSeat getById(int id);

    BusSeat updatePriceById(int id, double price);

    void deleteById(int id);
}
