package com.demo.country.details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.country.details.entity.City;
import com.demo.country.details.repo.CityRepo;

@Service
public class CityService {
	
	@Autowired
	private CityRepo cityRepo;

	/**
	 * 
	 * @param paging
	 * @return
	 */
	public ResponseEntity<Page<City>> getCities(Pageable paging) {
		Page<City> cityPage = cityRepo.findAll(paging);
		return ResponseEntity.status(HttpStatus.OK).body(cityPage);
	}

}
