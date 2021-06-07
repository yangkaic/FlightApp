package com.flightapp.flightservice.service;

import com.flightapp.flightservice.entity.Airline;
import com.flightapp.flightservice.entity.Flight;
import com.flightapp.flightservice.entity.Plane;

import java.util.List;

public interface FlightService {

    Airline createAirline(Airline airline);

    Airline updateAirline(Airline airline);

    List<Airline> getAllAirlines();

    Airline getAirlineById(int airlineId);

    Plane createPlane(Plane plane);

    Plane updatePlane(Plane plane);

    Plane getPlaneById(int planeId);

    List<Flight> getAllFlights();

    Flight getFlightById(int flightId);
}
