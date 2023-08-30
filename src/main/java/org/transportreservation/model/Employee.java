package org.transportreservation.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Employee {
    private int id_employee;
    private String employee_firstname;
    private String employee_lastname;
    private String employee_address;
    private long employee_national_id;
    private String employee_mobile_number;
    private String employee_role;
    private String employee_password;
}
