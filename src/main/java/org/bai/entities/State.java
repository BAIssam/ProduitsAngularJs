package org.bai.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class State {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nameState;
	
	@ManyToOne
	private Country country;
	
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(String nameState, Country country) {
		super();
		this.nameState = nameState;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}	

}
