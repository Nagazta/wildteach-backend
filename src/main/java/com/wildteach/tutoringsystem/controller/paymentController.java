package com.wildteach.tutoringsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wildteach.tutoringsystem.entity.paymentEntity;
import com.wildteach.tutoringsystem.service.paymentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class paymentController {
    @Autowired
    private paymentService paymentService;

    // Endpoint to add a new payment
    @PostMapping("/addPayment")
    public String addPayment(@RequestBody paymentEntity payment) {
        paymentService.savePayment(payment);
        return "New payment is added";
    }

    // Endpoint to get all payments
    @GetMapping("/getAllPayments")
    public List<paymentEntity> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Endpoint to get a payment by ID
    @GetMapping("/getPaymentById/{id}")
    public paymentEntity getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // Endpoint to update a payment by ID
    @PutMapping("/updatePayment/{id}")
    public paymentEntity updatePayment(@PathVariable Long id, @RequestBody paymentEntity paymentDetails) {
        paymentEntity updatedPayment = paymentService.updatePayment(id, paymentDetails);
        if (updatedPayment != null) {
            return updatedPayment;
        } else {
            return null;
        }
    }

    // Endpoint to delete a payment by ID
    @DeleteMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment with ID " + id + " has been deleted.";
    }

    @GetMapping("/totalCompletedPayments")
    public Double getTotalCompletedPayments() {
        return paymentService.getTotalCompletedPayments();
    }

}
