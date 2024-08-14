package com.neueda.payments.service;

import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
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
    public List<Payment> getAllByOrderId(String id) {
        return paymentsRepository.findAllByOrderId(id);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentsRepository.findById(id).orElse(null);
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
