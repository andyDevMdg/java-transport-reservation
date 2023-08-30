package org.transportreservation.controller;

import org.springframework.web.bind.annotation.*;
import org.transportreservation.model.Bus;
import org.transportreservation.service.BusService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BusController {
    private BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping("/bus")
    public Bus addBus(@RequestBody Bus bus) throws SQLException {
        return busService.insertBus(bus);
    }

    @GetMapping("/bus")
    public List<Bus> findAllBus() throws SQLException {
        return busService.getAll();
    }


    @GetMapping("/bus/search/{id}")
    public Bus findBusById(@PathVariable int id) throws SQLException {
        return busService.getById(id);
    }

    @PatchMapping("/bus/edit/places/{id}")
    public Bus updatePlacesById(@PathVariable int id, @RequestBody int numberOfPlaces) throws SQLException {
        return busService.updatePlacesById(id, numberOfPlaces);
    }

    @DeleteMapping("/bus/{id}")
    public void deleteBusById(@PathVariable int id) throws SQLException {
        busService.deleteById(id);
    }
}
