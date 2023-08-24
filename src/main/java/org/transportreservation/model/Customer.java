package org.transportreservation.model;

import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Customer {
    private int customer_id;
    private String customer_firstname;
    private String customer_lastname;
    private String customer_address;
    private double customer_national_id;
    private String customer_mobile_number;

    public Customer(int customer_id, String customer_firstname, String customer_lastname, String customer_address, double customer_national_id, String customer_mobile_number) {
        this.customer_id = customer_id;
        this.customer_firstname = customer_firstname;
        this.customer_lastname = customer_lastname;
        this.customer_address = customer_address;
        this.customer_national_id = customer_national_id;
        this.customer_mobile_number = customer_mobile_number;
    }
}
