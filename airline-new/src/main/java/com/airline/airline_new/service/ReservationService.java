package com.airline.airline_new.service;

import com.airline.airline_new.model.Reservation;
import com.airline.airline_new.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation bookTicket(Reservation reservation) {

        String pnr =
                "PNR" +
                UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        reservation.setPnr(pnr);
        reservation.setBookingStatus("CONFIRMED");

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllBookings() {
        return reservationRepository.findAll();
    }
    public void cancelTicket(Long reservationId) {

    Reservation reservation =
            reservationRepository.findById(reservationId).orElse(null);

    if (reservation != null) {
        reservation.setBookingStatus("CANCELLED");
        reservationRepository.save(reservation);
    }
}
}