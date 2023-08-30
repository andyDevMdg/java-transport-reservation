package org.transportreservation.repository;

import org.transportreservation.model.Booking;

import java.util.List;

public interface BookingInterfaceDAO {
    void insert(Booking booking);

    List<Booking> getAll();

    Booking getById(int id);

    Booking updateDestinationById(int id, String destination);

    void deleteById(int id);
}
