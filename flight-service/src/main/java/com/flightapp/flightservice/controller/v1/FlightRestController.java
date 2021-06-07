package com.flightapp.flightservice.controller.v1;

import com.flightapp.flightservice.entity.Airline;
import com.flightapp.flightservice.entity.Flight;
import com.flightapp.flightservice.entity.Plane;
import com.flightapp.flightservice.entity.Seat;
import com.flightapp.flightservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FlightRestController {

    @Autowired
    FlightService flightService;

    @PostMapping("/airline") // create airlane
    public Airline createAirline(@RequestBody Airline airline) {

        return flightService.createAirline(airline);
    }

    @PutMapping("/airline") // update airlane
    public Airline updateAirline(@RequestBody Airline airline) {

        return flightService.updateAirline(airline);
    }

    @GetMapping("/airline") // get all airlanes
    public List<Airline> getAllAirlines() {

        return flightService.getAllAirlines();
    }

    @GetMapping("/airline/{airlineId}") // get airlane by id
    public Airline getAirlineById(@PathVariable int airlineId) {

        return flightService.getAirlineById(airlineId);
    }

    @PostMapping("/plane") // create plane
    public Plane createPlane(@RequestBody Plane plane) {

        for (int i = 1; i <= 5; i++) {
            for (char c = 'A'; c <= 'F'; c++) {
                Seat seat = new Seat();
                seat.setSeatNumber("" + i + c);
                seat.setAvailable(true);
                plane.addSeat(seat);
            }
        }
        return flightService.createPlane(plane);
    }

    @PutMapping("/plane") // update plane
    public Plane updatePlane(@RequestBody Plane plane) {

        return flightService.updatePlane(plane);
    }

    @GetMapping("/plane/{planeId}") // get plane by id
    public Plane getPlaneById(@PathVariable int planeId) {

        return flightService.getPlaneById(planeId);
    }

    @PostMapping("/flight/airline/{airlineId}/plane/{planeId}") // create flight
    public Flight createFlight(@PathVariable int airlineId,
                               @PathVariable int planeId,
                               @RequestBody Flight flight) {

        Plane plane = flightService.getPlaneById(planeId);
        plane.setFlight(flight);
        plane = flightService.updatePlane(plane);

        flight = plane.getFlight();

        Airline airline = flightService.getAirlineById(airlineId);
        airline.addFlight(flight);
        flightService.updateAirline(airline);

        return flight;
    }

    @GetMapping("/flight/airline/{airlineId}") // get all flights for specific airline
    public List<Flight> getAllFlightsForAirline(@PathVariable int airlineId) {

        Airline airline = flightService.getAirlineById(airlineId);

        return airline.getFlights();
    }

    @GetMapping("/flight/{flightId}") // get flight by id
    public Flight getFlightById(@PathVariable int flightId) {

        return flightService.getFlightById(flightId);
    }

    @GetMapping("/flight") // get all flights
    public List<Flight> getAllFlights() {

        return flightService.getAllFlights();
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
