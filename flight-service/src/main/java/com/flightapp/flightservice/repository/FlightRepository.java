package com.flightapp.flightservice.repository;

import com.flightapp.flightservice.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
