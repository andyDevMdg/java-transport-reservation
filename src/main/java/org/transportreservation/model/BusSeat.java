package org.transportreservation.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class BusSeat {
    private int id_bus_seat;
    private double bus_seat_price;
    private Boolean is_taken;
    private int id_bus;
}
