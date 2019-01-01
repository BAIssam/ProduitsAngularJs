package org.bai.dao;

import org.bai.entities.Produits;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitsRepository extends JpaRepository<Produits, Long> {
	
	@Query("SELECT p FROM Produits p WHERE p.designation LIKE :d")
	public Page<Produits> chercherProduits(@Param("d") String mc, Pageable pageable);

}
