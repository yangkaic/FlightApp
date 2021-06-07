package com.flightapp.flightservice.service;

import com.flightapp.flightservice.entity.Airline;
import com.flightapp.flightservice.entity.Flight;
import com.flightapp.flightservice.entity.Plane;
import com.flightapp.flightservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PlaneRepository planeRepository;

    @Autowired
    SeatRepository seatRepository;

    @Override
    public Airline createAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public Airline updateAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline getAirlineById(int airlineId) {
        Optional<Airline> op = airlineRepository.findById(airlineId);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public Plane createPlane(Plane plane) {
        return planeRepository.save(plane);
    }

    @Override
    public Plane updatePlane(Plane plane) {
        return planeRepository.save(plane);
    }

    @Override
    public Plane getPlaneById(int planeId) {
        Optional<Plane> op = planeRepository.findById(planeId);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(int flightId) {
        Optional<Flight> op = flightRepository.findById(flightId);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }
}
