package com.omkar.flightreservation.services;

import com.omkar.flightreservation.dto.ReservationRequest;
import com.omkar.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
