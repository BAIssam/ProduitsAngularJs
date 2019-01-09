package org.bai.dao;

import java.util.List;

import org.bai.entities.Country;
import org.bai.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
	
	List<State> findByCountry(Country country);
	

}
