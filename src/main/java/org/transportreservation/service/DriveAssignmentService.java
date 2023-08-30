package org.transportreservation.service;

import org.springframework.stereotype.Service;
import org.transportreservation.model.DriveAssignment;
import org.transportreservation.repository.DriveAssignmentDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class DriveAssignmentService {
    private DriveAssignmentDAO driveAssignmentDAO;

    public DriveAssignmentService(DriveAssignmentDAO driveAssignmentDAO){
        this.driveAssignmentDAO = driveAssignmentDAO;
    }

    public DriveAssignment insertDriveAssignment(DriveAssignment driveAssignment) throws SQLException {
        driveAssignmentDAO.insert(driveAssignment);
        return driveAssignment;
    }

    public List<DriveAssignment> getAll() throws SQLException {
        return driveAssignmentDAO.getAll();
    }

    public DriveAssignment getById(int id) throws SQLException {
        return driveAssignmentDAO.getById(id);
    }

    public DriveAssignment updateDriverById(int id, int driver) throws SQLException {
        return driveAssignmentDAO.updateDriverById(id, driver);
    }

    public void deleteById(int id) throws SQLException {
        driveAssignmentDAO.deleteById(id);
    }
}
