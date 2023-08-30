package org.transportreservation.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class DriveAssignment {
    private int id_drive_assignment;
    private int id_bus;
    private int id_driver;
}
