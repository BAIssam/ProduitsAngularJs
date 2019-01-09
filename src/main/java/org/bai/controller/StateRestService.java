package org.bai.controller;

import java.util.List;

import org.bai.dao.StateRepository;
import org.bai.entities.Country;
import org.bai.entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateRestService {
	
	@Autowired
	private StateRepository stateRepository;
	
	@GetMapping(value="/state/country/{id}")
	public List<State> listStateByCountryId(@PathVariable Long id){
		
		Country country = new Country();
		country.setId(id);
		
		return stateRepository.findByCountry(country);
	}

}
