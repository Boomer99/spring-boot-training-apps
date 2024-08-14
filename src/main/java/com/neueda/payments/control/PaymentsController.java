package com.neueda.payments.control;

import com.neueda.payments.model.Payment;
import com.neueda.payments.service.PaymentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/payments")
@RestController
public class PaymentsController {

    private PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentsService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable long id) {
        return paymentsService.getPaymentById(id);
    }
}
