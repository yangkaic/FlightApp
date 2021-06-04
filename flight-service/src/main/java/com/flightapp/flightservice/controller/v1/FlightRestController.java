package com.flightapp.flightservice.controller.v1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FlightRestController {

    @PostMapping("/flight/search")
    public String searchFlight() {
        return "Flight Search";
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
