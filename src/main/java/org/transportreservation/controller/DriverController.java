package org.transportreservation.controller;

import org.springframework.web.bind.annotation.*;
import org.transportreservation.model.Driver;
import org.transportreservation.service.DriverService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class DriverController {
    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/drivers")
    public Driver addDriver(@RequestBody Driver driver) throws SQLException {
        return driverService.insertDriver(driver);
    }

    @GetMapping("/drivers")
    public List<Driver> findAllDriver() throws SQLException {
        return driverService.getAll();
    }

    @GetMapping("/drivers/search/")
    public List<Driver> findDriverByName(@RequestParam(name = "name") String name) throws SQLException {
        return driverService.getByName(name);
    }

    @GetMapping("/drivers/search/{id}")
    public Driver findDriverById(@PathVariable int id) throws SQLException {
        return driverService.getById(id);
    }

    @PatchMapping("/drivers/edit/{id}")
    public Driver updatePhoneById(@PathVariable int id, @RequestBody String phone) throws SQLException {
        return driverService.updatePhoneById(id, phone);
    }

    @DeleteMapping("/drivers/{id}")
    public void deleteDriverById(@PathVariable int id) throws SQLException {
        driverService.deleteById(id);
    }
}
