package com.demo.country.details;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.country.details.controller.CountryController;
import com.demo.country.details.dto.CountryDTO;
import com.demo.country.details.dto.MessageResponse;
import com.demo.country.details.util.ResponseMessages;

@SpringBootTest
class CountryDetailsWorkshopApplicationTests {
	@Autowired
	CountryController countryController;

//	@Autowired
//	CountryService countryService;
	
	
	@Test
	void findCountryByCode() {
		CountryDTO countryDto = new CountryDTO();

		countryDto = (CountryDTO) countryController.getCountry("BHR").getBody();

		assertEquals("Bahrain", countryDto.getName());
		assertEquals("Asia", countryDto.getContinent());
		assertEquals("Arabic", countryDto.getCountryLanguage());
		assertEquals(73, countryDto.getLifeExpectancy());
		assertEquals(617000, countryDto.getPopulation());

	}
	@Test
	void countryNotFound() {
		MessageResponse messageResponse = new MessageResponse();

		messageResponse = (MessageResponse) countryController.getCountry("EWQ").getBody();

		assertEquals(ResponseMessages.INVALID_COUNTRY_CODE,messageResponse.getMessage());

	}
	
	@Test
	void dataBaseDown() {
		MessageResponse messageResponse = new MessageResponse();
		
		messageResponse = (MessageResponse) countryController.getCountry("BHR").getBody();

		assertEquals(ResponseMessages.INTERNAL_ERROR,messageResponse.getMessage());

	}
}
