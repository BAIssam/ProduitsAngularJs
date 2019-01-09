package org.bai.controller;

import java.util.List;

import org.bai.dao.CategorieRepository;
import org.bai.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieRestService {
	
	@Autowired
	CategorieRepository categorieRepository;
	
	@GetMapping(value="/categories")
	public List<Categorie> listCategorie(){
		return categorieRepository.findAll();
	}

}
