package com.gestionEtudiant.entities;

public class Filiere {
	private String code;
	private String nom;
	private String description;

	public Filiere(String code, String nom, String description) {
		super();
		this.code = code;
		this.nom = nom;
		this.description = description;
	}

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Filiere [code=" + code + ", nom=" + nom + ", description=" + description + "]";
	}

}
