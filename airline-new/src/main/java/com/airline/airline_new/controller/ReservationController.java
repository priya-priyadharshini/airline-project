package com.airline.airline_new.controller;

import com.airline.airline_new.model.Reservation;
import com.airline.airline_new.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Open booking page with selected flight id
    @GetMapping("/book/{flightId}")
    public String bookingPage(@PathVariable Long flightId, Model model) {

        Reservation reservation = new Reservation();
        reservation.setFlightId(flightId);

        model.addAttribute("reservation", reservation);

        return "book-ticket";
    }

    // Save booking
    @PostMapping("/book")
    public String bookTicket(@ModelAttribute Reservation reservation,
                             Model model) {

        Reservation savedReservation =
                reservationService.bookTicket(reservation);

        model.addAttribute("pnr", savedReservation.getPnr());
        model.addAttribute("message", "Ticket Booked Successfully");

        return "booking-success";
    }
    @GetMapping("/booking-history")
public String bookingHistory(Model model) {

    model.addAttribute(
            "bookings",
            reservationService.getAllBookings()
    );

    return "booking-history";
}
@GetMapping("/cancel/{id}")
public String cancelTicket(@PathVariable Long id) {

    reservationService.cancelTicket(id);

    return "redirect:/booking-history";
}
}