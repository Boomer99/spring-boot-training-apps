package com.neueda.payments.service;

import com.neueda.payments.model.Payment;

import java.util.*;

public interface PaymentsService {

    List<Payment> getAllPayments();

    List<Payment> getAllByOrderId(String orderId);

    Payment getPaymentById(long id);

    List<Payment> getPaymentsByCountry(String country);

    Payment save(Payment payment);
}
