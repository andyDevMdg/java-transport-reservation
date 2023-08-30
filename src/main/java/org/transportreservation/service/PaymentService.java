package org.transportreservation.service;

import org.springframework.stereotype.Service;
import org.transportreservation.model.Payment;
import org.transportreservation.repository.PaymentDAO;

import java.sql.SQLException;
import java.util.List;

@Service
public class PaymentService {
    private PaymentDAO paymentDAO;

    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public Payment insertPayment(Payment payment) throws SQLException {
        paymentDAO.insert(payment);
        return payment;
    }

    public List<Payment> getAll() throws SQLException {
        return paymentDAO.getAll();
    }

    public Payment getById(int id) throws SQLException {
        return paymentDAO.getById(id);
    }

    public Payment updateAmountById(int id, double amount) throws SQLException {
        return paymentDAO.updateAmountById(id, amount);
    }

    public void deleteById(int id) throws SQLException {
        paymentDAO.deleteById(id);
    }
}
