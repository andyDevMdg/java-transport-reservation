package org.transportreservation.service;

import org.transportreservation.model.Bus;
import org.transportreservation.repository.BusDAO;

import java.sql.SQLException;
import java.util.List;

public class BusService {
    private BusDAO busDAO;

    public BusService(BusDAO busDAO) {
        this.busDAO = busDAO;
    }

    public Bus insertBus(Bus bus) throws SQLException {
        busDAO.insert(bus);
        return bus;
    }

    public List<Bus> getAll() throws SQLException {
        return busDAO.getAll();
    }

    public Bus getById(int id) throws SQLException {
        return busDAO.getById(id);
    }

    public Bus updatePlacesById(int id, int numberOfPlaces) throws SQLException {
        return busDAO.updatePlacesById(id, numberOfPlaces);
    }

    public void deleteById(int id) throws SQLException {
        busDAO.deleteById(id);
    }
}
