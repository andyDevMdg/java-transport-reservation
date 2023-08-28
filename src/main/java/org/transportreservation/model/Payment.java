package org.transportreservation.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Payment {
    private int id_payment;
    private String payment_method;
    private String payment_amount;
}
