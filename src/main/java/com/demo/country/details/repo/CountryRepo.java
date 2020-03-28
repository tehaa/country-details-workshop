package com.demo.country.details.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.country.details.dto.CountryDTO;
import com.demo.country.details.entity.Country;

public interface CountryRepo extends JpaRepository<Country, String> {

	@Query(value = "select new com.demo.country.details.dto.CountryDTO(c.name as name,c.continent as continent,c.population as population ,"
			+ "c.lifeExpectancy as lifeExpectancy,cl.language as countryLanguage, cl.percentage as percentage )"
			+ " from Country c LEFT JOIN CountryLanguage cl ON c.code = cl.country.code where c.code = :code and cl.isOfficial is true  order by cl.percentage desc ")
	List<CountryDTO> getCountryFromCode(@Param("code") String code,Pageable pageable);

}
