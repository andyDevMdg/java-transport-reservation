package org.transportreservation.controller;

import org.springframework.web.bind.annotation.*;
import org.transportreservation.model.DriveAssignment;
import org.transportreservation.service.DriveAssignmentService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class DriveAssignmentController {
    private DriveAssignmentService driveAssignmentService;

    public DriveAssignmentController(DriveAssignmentService driveAssignmentService){
        this.driveAssignmentService = driveAssignmentService;
    }

    @PostMapping("/assignment")
    public DriveAssignment addDriveAssignment(@RequestBody DriveAssignment driveAssignment) throws SQLException {
        return driveAssignmentService.insertDriveAssignment(driveAssignment);
    }

    @GetMapping("/assignment")
    public List<DriveAssignment> findAllDriveAssignment() throws SQLException {
        return driveAssignmentService.getAll();
    }

    @GetMapping("/assignment/search/{id}")
    public DriveAssignment findDriveAssignmentById(@PathVariable int id) throws SQLException {
        return driveAssignmentService.getById(id);
    }

    @PatchMapping("/assignment/edit/{id}")
    public DriveAssignment updateDriverById(@PathVariable int id, @RequestBody String assignedDriver) throws SQLException {
        int driver = Integer.parseInt(assignedDriver);
        return driveAssignmentService.updateDriverById(id, driver);
    }

    @DeleteMapping("/assignment/{id}")
    public void deleteBusById(@PathVariable int id) throws SQLException {
        driveAssignmentService.deleteById(id);
    }
}
