package org.transportreservation.controller;

import org.springframework.web.bind.annotation.*;
import org.transportreservation.model.Booking;
import org.transportreservation.service.BookingService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public Booking addBooking(@RequestBody Booking booking) throws SQLException {
        return bookingService.insertBooking(booking);
    }

    @GetMapping("/booking")
    public List<Booking> findAllBooking() throws SQLException {
        return bookingService.getAll();
    }

    @GetMapping("/booking/search/{id}")
    public Booking findBookingById(@PathVariable int id) throws SQLException {
        return bookingService.getById(id);
    }

    @PatchMapping("/booking/edit/{id}")
    public Booking updateDestinationById(@PathVariable int id, @RequestBody String destination) throws SQLException {
        return bookingService.updateDestinationById(id, destination);
    }

    @DeleteMapping("/booking/{id}")
    public void deleteBusById(@PathVariable int id) throws SQLException {
        bookingService.deleteById(id);
    }

}
