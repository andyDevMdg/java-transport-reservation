DROP DATABASE IF EXISTS transport_booking;

CREATE DATABASE transport_booking;

\c transport_booking


CREATE TABLE customer(
    id_customer serial primary key,
    customer_firstname varchar(200) not null,
    customer_lastname varchar(200) not null,
    customer_username varchar(200) not null,
    customer_password varchar(200) not null,
    customer_address varchar(1000) not null,
    customer_national_id bigint not null,
    customer_mobile_number varchar(200) not null,
    customer_registration_date timestamp without time zone default current_timestamp not null
);


CREATE TABLE employee(
    id_employee serial primary key,
    employee_firstname varchar(200) not null,
    employee_lastname varchar(200) not null,
    employee_address varchar(1000) not null,
    employee_national_id bigint not null,
    employee_mobile_number varchar(200) not null,
    employee_role varchar(200) not null,
    employee_password varchar(200) not null
);


CREATE TABLE bus(
    id_bus serial primary key,
    bus_plate_number varchar(20) not null,
    bus_number_of_places int not null,
    bus_brand varchar(20) not null
);


CREATE TABLE bus_seat(
    id_bus_seat serial primary key,
    bus_seat_price float not null,
    is_taken boolean default false,
    id_bus int not null,
    CONSTRAINT fk_bus_bus_seat FOREIGN KEY (id_bus) REFERENCES bus(id_bus)
);


CREATE TABLE driver(
    id_driver serial primary key,
    driver_firstname varchar(200) not null,
    driver_lastname varchar(200) not null,
    driver_address varchar(1000) not null,
    driver_national_id bigint not null,
    driver_mobile_number varchar(20) not null
);

CREATE TABLE payment(
    id_payment serial primary key,
    payment_method varchar(200) not null,
    payment_amount float not null
);


CREATE TABLE booking(
    id_booking serial primary key,
    departure_location varchar(200) not null,
    departure_datetime timestamp without time zone not null,
    destination_location varchar(200) not null,
    destination_datetime timestamp without time zone not null,
    is_paid boolean default false,
    id_customer int not null,
    id_payment int not null,
    id_bus_seat int not null,
    id_employee int not null,
    CONSTRAINT fk_customer_booking FOREIGN KEY (id_customer) REFERENCES customer(id_customer),
    CONSTRAINT fk_payment_booking FOREIGN KEY (id_payment) REFERENCES payment(id_payment),
    CONSTRAINT fk_bus_seat_booking FOREIGN KEY (id_bus_seat) REFERENCES bus_seat(id_bus_seat),
    CONSTRAINT fk_employee_booking FOREIGN KEY (id_employee) REFERENCES employee(id_employee)
);



CREATE TABLE drive_assignment(
    id_drive_assignment serial primary key,
    id_bus int not null,
    id_driver int not null,
    CONSTRAINT fk_bus_assignment FOREIGN KEY (id_bus) REFERENCES bus(id_bus),
    CONSTRAINT fk_driver_assignment FOREIGN KEY (id_driver) REFERENCES driver(id_driver)
);

