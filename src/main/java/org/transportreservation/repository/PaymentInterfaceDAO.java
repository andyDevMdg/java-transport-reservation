package org.transportreservation.repository;

import org.transportreservation.model.Payment;

import java.util.List;

public interface PaymentInterfaceDAO {
    void insert(Payment payment);

    List<Payment> getAll();

    Payment getById(int id);

    Payment updateAmountById(int id, double amount);

    void deleteById(int id);
}
