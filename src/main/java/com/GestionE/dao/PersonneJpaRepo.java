package com.GestionE.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.GestionE.entites.Personne;

public interface PersonneJpaRepo extends JpaRepository<Personne, Long>{
	
	//recherche une personne par son nom
	public List<Personne> findByNom(String n);
	
	//selectionner page par page (pagination)
	public Page<Personne> findByNom(String n,Pageable pageable);
	
	//rechercher une personneue
	
	@Query("select p from Personne p where p.nom  like :x ")
	public Page <Personne> chercherPersonnes(@Param("x")String mc,Pageable pageable);
	
	//chercher une peronnne entre un interval d'age
	
	@Query("Select p from Personne p where p.age >:x and p.age<:y")
	public List<Personne> chercherPersonnes(@Param("x")Date d1,@Param("y")Date d2);
	
	

}
