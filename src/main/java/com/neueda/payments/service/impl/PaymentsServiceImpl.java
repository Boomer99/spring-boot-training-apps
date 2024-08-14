package com.neueda.payments.service.impl;

import com.neueda.payments.exceptions.PaymentNotFoundException;
import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
import com.neueda.payments.service.PaymentsService;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    private PaymentsRepository paymentsRepository;

    public PaymentsServiceImpl(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }

    @Override
    public List<Payment> getAllByOrderId(String orderId) {
        return paymentsRepository.findAllByOrderId(orderId);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentsRepository.findById(id)
                .orElseThrow(() => new PaymentNotFoundException() + id);
    }

    @Override
    public List<Payment> getPaymentsByCountry(String country) {
        return paymentsRepository.findAllByCountry(country);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentsRepository.save(payment);
    }

}
