package org.transportreservation.service;

import org.springframework.stereotype.Service;
import org.transportreservation.model.Driver;
import org.transportreservation.model.Employee;
import org.transportreservation.repository.DriverDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class DriverService {
    private DriverDAO driverDAO;

    public DriverService(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    public Driver insertDriver(Driver driver) throws SQLException {
        driverDAO.insert(driver);
        return driver;
    }

    public List<Driver> getAll() throws SQLException {
        return driverDAO.getAll();
    }

    public List<Driver> getByName(String name) throws SQLException {
        return driverDAO.getByName(name);
    }

    public Driver getById(int id) throws SQLException {
        return driverDAO.getById(id);
    }

    public Driver updatePhoneById(int id, String phone) throws SQLException{
        return driverDAO.updatePhoneById(id, phone);
    }

    public void deleteById(int id) throws SQLException {
        driverDAO.deleteById(id);
    }
}
