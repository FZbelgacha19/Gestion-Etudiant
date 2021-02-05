package com.gestionEtudiant.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionEtudiant.Metier.IGestionEtudiant;
import com.gestionEtudiant.entities.Etudiant;
import com.gestionEtudiant.entities.Filiere;

public class GestionEtudiantDaoImp implements IGestionEtudiant {

	@Override
	public void addEtudiant(Etudiant e) {

		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO etudiant(nom, prenom, datenaissance, villenaissance, cni, apogee, nationalite,email) VALUES (?,?,?,?,?,?,?,?)");
			stmt.setString(1, e.getNom());
			stmt.setString(2, e.getPrenom());
			stmt.setDate(3, e.getDateNaissance());
			stmt.setString(4, e.getVilleNaissance());
			stmt.setString(5, e.getCni());
			stmt.setInt(6, e.getApogee());
			stmt.setString(7, e.getNationalite());
			stmt.setString(8, e.getEmail());
			stmt.execute();
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
	}

	@Override
	public Etudiant getEtudiant(String str) {
		Etudiant e = new Etudiant();
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM  etudiant WHERE cni=? OR apogee=?");
			stmt.setString(1, str);
			if (str.matches("[0-9]+") && str.length() > 0)
				stmt.setInt(2, Integer.parseInt(str));
			else
				stmt.setInt(2, 0);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				e.setApogee(result.getInt("apogee"));
				e.setCni(result.getString("cni"));
				e.setDateNaissance(result.getDate("datenaissance"));
				e.setEmail(result.getString("email"));
				e.setNationalite(result.getString("nationalite"));
				e.setNom(result.getString("nom"));
				e.setPrenom(result.getString("prenom"));
				e.setVilleNaissance(result.getString("villenaissance"));
			}
			return e;
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}

		return null;

	}

	@Override
	public List<Etudiant> getAllEtudiant() {
		List<Etudiant> ListEtud = new ArrayList<Etudiant>();
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM  etudiant");
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Etudiant e = new Etudiant();
				e.setApogee(result.getInt("apogee"));
				e.setCni(result.getString("cni"));
				e.setDateNaissance(result.getDate("datenaissance"));
				e.setEmail(result.getString("email"));
				e.setNationalite(result.getString("nationalite"));
				e.setNom(result.getString("nom"));
				e.setPrenom(result.getString("prenom"));
				e.setVilleNaissance(result.getString("villenaissance"));
				ListEtud.add(e);
			}
			return ListEtud;
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}

		return null;
	}

	@Override
	public void deletEtudiant(String str) {
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM etudiant WHERE apogee=?");
			if (str.matches("[0-9]+") && str.length() > 2)
				stmt.setInt(1, Integer.parseInt(str));
			else
				stmt.setInt(1, 0);
			stmt.execute();
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
	}

	@Override
	public void updateEtudiant(Etudiant e) {
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE etudiant SET nom=?,prenom=?,datenaissance=?,villenaissance=?,cni=?,nationalite=?,email=? WHERE apogee=?");
			stmt.setString(1, e.getNom());
			stmt.setString(2, e.getPrenom());
			stmt.setDate(3, e.getDateNaissance());
			stmt.setString(4, e.getVilleNaissance());
			stmt.setString(5, e.getCni());
			stmt.setString(6, e.getNationalite());
			stmt.setString(7, e.getEmail());
			stmt.setInt(8, e.getApogee());
			stmt.execute();
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
	}

	@Override
	public void addFilier(Filiere f) {
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO filiere(code, nom, description) VALUES (?,?,?)");
			stmt.setString(1, f.getCode());
			stmt.setString(2, f.getNom());
			stmt.setString(3, f.getDescription());
			stmt.execute();
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
	}

	@Override
	public Filiere getFiliere(String str) {
		Filiere f = new Filiere();
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT code, nom, description FROM filiere WHERE code = ? OR nom = ?");
			stmt.setString(1, str);
			stmt.setString(2, str);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				f.setCode(result.getString("code"));
				f.setNom(result.getString("nom"));
				f.setDescription(result.getString("description"));
			}
			return f;
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}

		return null;
	}

	@Override
	public List<Filiere> getAllFiliere() {
		List<Filiere> filieres = new ArrayList<Filiere>();
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT code, nom, description FROM filiere");
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				filieres.add(new Filiere(result.getString("code"), result.getString("nom"),
						result.getString("description")));
			}
			return filieres;
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
		return null;
	}

	@Override
	public void updateFilier(Filiere f) {
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE Filiere SET nom=?, description=? WHERE code=?");
			stmt.setString(1, f.getNom());
			stmt.setString(2, f.getDescription());
			stmt.setString(3, f.getCode());
			stmt.execute();
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}

	}

	@Override
	public void deleteFilier(String str) {
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Filiere WHERE code=?");
			stmt.setString(1, str);
			stmt.execute();
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
	}

	@Override
	public void addEtudiantToFiliere(Etudiant e, Filiere f) {
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO inscrits(apogee, cni, code) VALUES (?,?,?)");
			stmt.setInt(1, e.getApogee());
			stmt.setString(2, e.getCni());
			stmt.setString(3, f.getCode());
			stmt.execute();
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
	}

	@Override
	public void deleteEtudiantFromFiliere(Etudiant e, Filiere f) {
		try {
			System.out.println(e);
			System.out.println(f);
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM inscrits WHERE code=? AND cni=?");
			stmt.setString(1, f.getCode());
			stmt.setString(2, e.getCni());
			stmt.execute();
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
	}

	@Override
	public List<Etudiant> getEtudiantsByFiliere(String str) {
		List<Etudiant> etudiant = new ArrayList<Etudiant>();
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT apogee, cni, code FROM inscrits WHERE code = ?");
			stmt.setString(1, str);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				etudiant.add(this.getEtudiant(result.getString("cni")));
			}
			return etudiant;
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
		return null;
	}

	@Override
	public Filiere getFiliereOfEtudiant(String str) {
		Filiere f = new Filiere();
		try {
			Connection conn = ConfigDB.getUnique().getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT apogee, cni, code FROM inscrits WHERE cni = ? OR apogee = ?");
			stmt.setString(1, str);
			if (str.matches("[0-9]+") && str.length() > 2)
				stmt.setInt(2, Integer.parseInt(str));
			else
				stmt.setInt(2, 0);

			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				f = this.getFiliere(result.getString("code"));
			}
			return f;
		} catch (SQLException ex) {
			System.err.println("Erreur : " + ex.getMessage());
		}
		return null;
	}

}
