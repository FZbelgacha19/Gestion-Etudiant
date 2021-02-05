package com.gestionEtudiant.entities;

import java.sql.Date;

public class Etudiant {
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String villeNaissance;
	private String cni;
	private int apogee;
	private String nationalite;
	private String email;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String nom, String prenom, Object dateNaissance, String villeNaissance, String cni, int apogee,
			String nationalite, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = (Date) dateNaissance;
		this.villeNaissance = villeNaissance;
		this.cni = cni;
		this.apogee = apogee;
		this.nationalite = nationalite;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public String getVilleNaissance() {
		return villeNaissance;
	}

	public String getCni() {
		return cni;
	}

	public int getApogee() {
		return apogee;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setVilleNaissance(String villeNaissance) {
		this.villeNaissance = villeNaissance;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public void setApogee(int apogee) {
		this.apogee = apogee;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", villeNaissance="
				+ villeNaissance + ", cni=" + cni + ", apogee=" + apogee + ", nationalite=" + nationalite + ", email="
				+ email + "]";
	}

}
