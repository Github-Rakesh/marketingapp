package com.marketingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp.entities.Leads;

public interface LeadsRepository extends JpaRepository<Leads, Integer> {

}
