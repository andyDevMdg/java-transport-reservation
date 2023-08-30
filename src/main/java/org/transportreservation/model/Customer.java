package org.transportreservation.model;

import lombok.*;


import java.sql.Timestamp;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private int id_customer;
    private String customer_firstname;
    private String customer_lastname;
    private String customer_username;
    private String customer_password;
    private String customer_address;
    private long customer_national_id;
    private String customer_mobile_number;
    private LocalDateTime customer_registration_date;
}
