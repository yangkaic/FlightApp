package com.flightapp.flightservice.repository;

import com.flightapp.flightservice.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
