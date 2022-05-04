package com.omkar.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
