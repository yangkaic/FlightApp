package com.flightapp.flightservice.controller.v1;

import com.flightapp.flightservice.entity.Flight;
import com.flightapp.flightservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FlightRestController {

    @Autowired
    FlightService flightService;

    @PostMapping("/flight/search")
    public List<Flight> searchFlight() {

        return null;
    }

    @PostMapping("/flight/booking/{flightid}")
    public String bookFlight(@PathVariable String flightid) {
        return "Book Flight " + flightid;
    }

    @GetMapping("/flight/ticket/{pnr}")
    public String getTicket(@PathVariable String pnr) {
        return "Get Ticket " + pnr;
    }
}
