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
    private float bus_seat_price;
    private boolean is_taken;
    private int id_bus;
}
