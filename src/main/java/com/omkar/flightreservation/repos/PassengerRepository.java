package com.omkar.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
