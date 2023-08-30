package org.transportreservation.service;

import org.transportreservation.model.Bus;
import org.transportreservation.model.BusSeat;
import org.transportreservation.repository.BusSeatDAO;

import java.sql.SQLException;
import java.util.List;

public class BusSeatService {
    private BusSeatDAO busSeatDAO;

    public BusSeatService(BusSeatDAO busSeatDAO){
        this.busSeatDAO = busSeatDAO;
    }

    public BusSeat insertBusSeat(BusSeat busSeat) throws SQLException {
        busSeatDAO.insert(busSeat);
        return busSeat;
    }

    public List<BusSeat> getAll() throws SQLException {
        return busSeatDAO.getAll();
    }

    public BusSeat getById(int id) throws SQLException {
        return busSeatDAO.getById(id);
    }

    public BusSeat updatePriceById(int id, double price) throws SQLException {
        return busSeatDAO.updatePriceById(id, price);
    }

    public void deleteById(int id) throws SQLException {
        busSeatDAO.deleteById(id);
    }
}
