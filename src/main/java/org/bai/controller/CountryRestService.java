package org.bai.controller;

import java.util.List;

import org.bai.dao.CountryRepository;
import org.bai.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryRestService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping(value="/pays")
	public List<Country> listCountry(){
		return countryRepository.findAll();
	}

}
