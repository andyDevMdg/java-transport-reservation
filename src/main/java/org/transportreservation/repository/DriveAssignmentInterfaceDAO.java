package org.transportreservation.repository;

import org.transportreservation.model.DriveAssignment;

import java.util.List;

public interface DriveAssignmentInterfaceDAO {
    void insert(DriveAssignment driveAssignment);

    List<DriveAssignment> getAll();

    DriveAssignment getById(int id);

    DriveAssignment updateDriverById(int id, int driver);

    void deleteById(int id);
}
