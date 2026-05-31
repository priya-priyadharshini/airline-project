package com.airline.airline_new.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.airline.airline_new.model.Flight;
import com.airline.airline_new.service.FlightService;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Add flight page
    @GetMapping("/add-flight")
    public String addFlightPage(Model model) {
        model.addAttribute("flight", new Flight());
        return "add-flight";
    }

    // Save flight
    @PostMapping("/add-flight")
    public String saveFlight(@ModelAttribute Flight flight) {
        flightService.addFlight(flight);
        return "redirect:/add-flight";
    }

    // Search page
    @GetMapping("/search-flights")
    public String searchFlightsPage() {
        return "search-flights";
    }

    // Search results
    @PostMapping("/search-flights")
    public String searchFlights(@RequestParam String source,
                                @RequestParam String destination,
                                Model model) {

        List<Flight> flights =
                flightService.searchFlights(source, destination);

        model.addAttribute("flights", flights);

        // IMPORTANT: show results page
        return "flight-results";
    }
}