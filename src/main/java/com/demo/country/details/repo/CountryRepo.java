package com.demo.country.details.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.country.details.entity.Country;

public interface CountryRepo  extends JpaRepository<Country, Character>{

}
