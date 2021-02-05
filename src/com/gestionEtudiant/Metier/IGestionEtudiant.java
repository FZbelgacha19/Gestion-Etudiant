package com.gestionEtudiant.Metier;
import java.util.List;

import com.gestionEtudiant.entities.*;


public interface IGestionEtudiant {
	
	public void addEtudiant(Etudiant e);
	
	public Etudiant getEtudiant(String str);
	public List<Etudiant> getAllEtudiant();
	
	public void deletEtudiant(String str);	
	public void updateEtudiant(Etudiant e);
	
	public void addFilier(Filiere f);
	public Filiere getFiliere(String str);
	public List<Filiere> getAllFiliere();
	public void updateFilier(Filiere f);
	public void deleteFilier(String str);
	
	public void addEtudiantToFiliere(Etudiant e, Filiere f);
	public void deleteEtudiantFromFiliere(Etudiant e, Filiere f);
	public List<Etudiant> getEtudiantsByFiliere(String str);
	public Filiere getFiliereOfEtudiant(String str);
}
