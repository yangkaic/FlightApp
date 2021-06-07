package com.flightapp.flightservice.repository;

import com.flightapp.flightservice.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Integer> {
}
