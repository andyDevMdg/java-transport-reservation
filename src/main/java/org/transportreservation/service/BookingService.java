package org.transportreservation.service;

import org.transportreservation.model.Booking;
import org.transportreservation.repository.BookingDAO;

import java.sql.SQLException;
import java.util.List;

public class BookingService {
    private BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDAO){
        this.bookingDAO = bookingDAO;
    }

    public Booking insertBooking(Booking booking) throws SQLException {
        bookingDAO.insert(booking);
        return booking;
    }

    public List<Booking> getAll() throws SQLException {
        return bookingDAO.getAll();
    }

    public Booking getById(int id) throws SQLException {
        return bookingDAO.getById(id);
    }

    public Booking updateDestinationById(int id, String destination) throws SQLException {
        return bookingDAO.updateDestinationById(id, destination);
    }

    public void deleteById(int id) throws SQLException {
        bookingDAO.deleteById(id);
    }
}
