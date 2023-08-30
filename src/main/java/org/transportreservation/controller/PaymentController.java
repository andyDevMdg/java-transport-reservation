package org.transportreservation.controller;

import org.springframework.web.bind.annotation.*;
import org.transportreservation.model.Payment;
import org.transportreservation.service.PaymentService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public Payment addPayment(@RequestBody Payment payment) throws SQLException {
        return paymentService.insertPayment(payment);
    }

    @GetMapping("/payment")
    public List<Payment> findAllPayment() throws SQLException {
        return paymentService.getAll();
    }

    @GetMapping("/payment/search/{id}")
    public Payment findPaymentById(@PathVariable int id) throws SQLException {
        return paymentService.getById(id);
    }

    @PatchMapping("/payment/edit/{id}")
    public Payment updateAmountById(@PathVariable int id, @RequestBody double amount) throws SQLException {
        return paymentService.updateAmountById(id, amount);
    }

    @DeleteMapping("/payment/{id}")
    public void deleteBusById(@PathVariable int id) throws SQLException {
        paymentService.deleteById(id);
    }
}
