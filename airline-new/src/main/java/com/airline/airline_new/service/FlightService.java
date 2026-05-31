package com.airline.airline_new.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.airline_new.model.Flight;
import com.airline.airline_new.repository.FlightRepository;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Search flights by source and destination
    public List<Flight> searchFlights(String source, String destination) {
        String src = source == null ? "" : source.trim().toLowerCase();
        String dest = destination == null ? "" : destination.trim().toLowerCase();
        return flightRepository.findAll()
            .stream()
            .filter(f -> f.getSource() != null && f.getDestination() != null)
            .filter(f -> f.getSource().trim().toLowerCase().equals(src)
                && f.getDestination().trim().toLowerCase().equals(dest))
            .toList();
    }

    // Get all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Add flight
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }
    public void deleteFlight(Long id) {
    flightRepository.deleteById(id);
}
}