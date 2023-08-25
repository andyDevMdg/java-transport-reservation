package org.transportreservation.model;

import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

public class Customer {
    private Long customer_id;
    private String customer_firstname;
    private String customer_lastname;
    private String customer_address;
    private double customer_national_id;
    private String customer_mobile_number;
}
