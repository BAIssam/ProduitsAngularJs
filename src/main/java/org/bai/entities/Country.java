package org.bai.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nameCountry;
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(String nameCountry) {
		super();
		this.nameCountry = nameCountry;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}

}
