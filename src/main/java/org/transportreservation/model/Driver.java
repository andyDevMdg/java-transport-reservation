package org.transportreservation.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Driver {
    private int id_driver;
    private String driver_firstname;
    private String driver_lastname;
    private String driver_address;
    private double driver_national_id;
    private String driver_mobile_number;
}
