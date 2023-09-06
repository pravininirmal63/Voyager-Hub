package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Travels;

public interface TravelsRepository extends JpaRepository<Travels, Long> 
{

}
