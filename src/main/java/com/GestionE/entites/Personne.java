package com.GestionE.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import net.bytebuddy.implementation.auxiliary.AuxiliaryType.SignatureRelevant;

@Entity
public class Personne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idPersonne;
	@NotNull
	private int cin;
	@NotNull
	@Column(length = 30)
	private String nom;
	private String prenom;
	private int age;
	
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Personne(int cin, String nom, String prenom, int age) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}


	public Long getIdPersonne() {
		return idPersonne;
	}


	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}


	public int getCin() {
		return cin;
	}


	public void setCin(int cin) {
		this.cin = cin;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
