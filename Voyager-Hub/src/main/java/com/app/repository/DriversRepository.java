package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Drivers;

public interface DriversRepository extends JpaRepository<Drivers, Long> {

	Drivers findByEmailAndPassword(String email,String password);

}
