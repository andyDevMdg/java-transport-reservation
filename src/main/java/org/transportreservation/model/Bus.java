package org.transportreservation.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Bus {
    private int id_bus;
    private String bus_plate_number;
    private String bus_number_of_places;
    private String bus_brand;
}
