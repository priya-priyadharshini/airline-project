package com.airline.airline_new.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {

    @GetMapping("/payment")
    public String paymentPage() {
        return "payment";
    }

    @PostMapping("/payment-success")
    public String paymentSuccess() {
        return "payment-success";
    }
    @GetMapping("/ticket")
public String ticketPage() {
    return "ticket";
}
@GetMapping("/seat-selection")
public String seatSelectionPage() {
    return "seat-selection";
}
}