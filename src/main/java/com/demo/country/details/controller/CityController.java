package com.demo.country.details.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.country.details.entity.City;
import com.demo.country.details.service.CityService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/city")
public class CityController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);
	
	@Autowired
	private CityService cityService;

	@ApiOperation(value = "This Api will get all cites in the world that registered in system and itis country ")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Page<City>> getCites(
			@RequestParam(required = false, defaultValue = "0", name = "pageIndex") Integer page,
			@RequestParam(required = false, defaultValue = "10", name = "pageSize") Integer size) {
		LOGGER.debug(" start api get cities to get page number : {} which size : {} in cities", page, size);
		
		Pageable paging = PageRequest.of(page, size);
		return cityService.getCities(paging);
	}


}
