package org.bai.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomcategorie;
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(String nomcategorie) {
		super();
		this.nomcategorie = nomcategorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomcategorie() {
		return nomcategorie;
	}

	public void setNomcategorie(String nomcategorie) {
		this.nomcategorie = nomcategorie;
	}
	
	
	
	

}
