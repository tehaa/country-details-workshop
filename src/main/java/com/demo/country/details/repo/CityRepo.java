package com.demo.country.details.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.country.details.entity.City;

public interface CityRepo extends JpaRepository<City, Integer>{

}
