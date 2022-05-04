package com.omkar.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
