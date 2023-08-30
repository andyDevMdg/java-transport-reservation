package org.transportreservation.model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Booking {
    private int id_booking;
    private String departure_location;
    private LocalDateTime departure_datetime;
    private String destination_location;
    private LocalDateTime destination_datetime;
    private Boolean is_paid;
    private int id_customer;
    private int id_payment;
    private int id_bus_seat;
    private int id_employee;
}
