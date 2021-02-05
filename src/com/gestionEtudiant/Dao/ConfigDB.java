package com.gestionEtudiant.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfigDB {
	private static ConfigDB unique;

	private ConfigDB() {

	}

	public static ConfigDB getUnique() {
		if (unique == null)
			unique = new ConfigDB();
		return unique;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgestionetudiant", "root", "");

		} catch (Exception ex) {
			System.err.println("Erreur : problème du pilote " + ex.getMessage());
		}
		return conn;
	}
}
