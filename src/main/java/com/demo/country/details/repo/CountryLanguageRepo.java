package com.demo.country.details.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.country.details.entity.CountryLanguage;
import com.demo.country.details.entity.CountryLanguageId;

public interface CountryLanguageRepo extends JpaRepository<CountryLanguage, CountryLanguageId> {

}
