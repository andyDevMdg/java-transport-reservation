package org.transportreservation.model;

import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

public class Customer {
    private Long id_customer;
    private String customer_firstname;
    private String customer_lastname;
    private String customer_username;
    private String customer_password;
    private String customer_address;
    private double customer_national_id;
    private String customer_mobile_number;
    private Timestamp customer_registration_date;
}
