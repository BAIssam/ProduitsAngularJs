package org.bai.controller;

import java.util.List;
import java.util.Optional;

import org.bai.dao.ProduitsRepository;
import org.bai.entities.Produits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduisRestService {
	
	@Autowired
	ProduitsRepository produitsRepository;
	
	@GetMapping(value="/produits")
	public List<Produits> listProduits(){
		return produitsRepository.findAll();
	}
	
	@GetMapping(value="/produits/{id}")
	public Optional<Produits> getProduitById(@PathVariable("id") Long id){
		return produitsRepository.findById(id);
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping(value="/chercherProduits")
	public Page<Produits> chercherProduits(
			String mc, 
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="5") int size){
		return produitsRepository.chercherProduits("%"+mc+"%", new PageRequest(page, size));
	}
	
	@PostMapping(value="/produits")
	public Produits addProduit(@RequestBody Produits p){
		return produitsRepository.save(p);
	}
	
	@PutMapping(value="/produits/{id}")
	public Produits updateProduit(@RequestBody Produits p, @PathVariable("id") Long id){
		p.setId(id);
		return produitsRepository.save(p);
	}
	
	@DeleteMapping(value="/produits/{id}")
	public void deleteProduit(@PathVariable Long id){
		produitsRepository.deleteById(id);;
	}

}
