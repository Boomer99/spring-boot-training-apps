package com.neueda.payments.control;

import com.neueda.payments.exceptions.PaymentNotFoundException;
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
    public List<Payment> getAllPayments(@RequestParam(value = "country", required = false) String country,
                                        @RequestParam(value = "orderId", required = false) String orderId) {
        if (country != null) {
            return paymentsService.getPaymentsByCountry(country);
        }
        if (orderId != null) {
            return paymentsService.getAllByOrderId(orderId);
        }
        return paymentsService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable long id) throws PaymentNotFoundException {
        return paymentsService.getPaymentById(id);
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentsService.save(payment);
    }

}
