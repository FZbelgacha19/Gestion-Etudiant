package com.gestionEtudiant.Dao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionEtudiant.Metier.IGestionEtudiant;
import com.gestionEtudiant.entities.Etudiant;
import com.gestionEtudiant.entities.Filiere;

//@WebServlet("/ControllerGestionEtudiant")
@WebServlet(name = "cs", urlPatterns = "*.do")
public class ControllerGestionEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IGestionEtudiant metier;

	@Override
	public void init() throws ServletException {
		metier = new GestionEtudiantDaoImp();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		if (path.equals("/addFiliere.do")) {
			request.getRequestDispatcher("addFiliere.jsp").forward(request, response);
		} // -------------------------------------------------------------------------------------
		else if (path.equals("/saveFiliere.do")) {
			Filiere f = new Filiere(request.getParameter("code"), request.getParameter("nom"),
					request.getParameter("description"));
			metier.addFilier(f);
			request.getRequestDispatcher("addFiliere.jsp").forward(request, response);

		} // -------------------------------------------------------------------------------------
		else if (path.equals("/addEtudiant.do")) {
			request.setAttribute("filieres", metier.getAllFiliere());
			request.getRequestDispatcher("addEtudiant.jsp").forward(request, response);

		} // -------------------------------------------------------------------------------------
		else if (path.equals("/saveEtudiant.do")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = sdf.parse(request.getParameter("dateN"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Etudiant e = new Etudiant(request.getParameter("nom"), request.getParameter("prenom"),
					new java.sql.Date(date.getTime()), request.getParameter("villeN"), request.getParameter("cni"),
					Integer.parseInt(request.getParameter("apogee")), request.getParameter("nationalite"),
					request.getParameter("email"));
			metier.addEtudiant(e);
			metier.addEtudiantToFiliere(e, metier.getFiliere(request.getParameter("filiere")));
			request.setAttribute("filieres", metier.getAllFiliere());
			request.getRequestDispatcher("addEtudiant.jsp").forward(request, response);
		} // ---------------------------------------------------------------------------------------------

		else if (path.equals("/SearchByFiliere.do")) {
			String Valeur = request.getParameter("valeur");
			if ((Valeur).isEmpty() == false) {
				Filiere f = metier.getFiliere(Valeur);
				request.setAttribute("filiere", f);
				List<Etudiant> e = metier.getEtudiantsByFiliere(f.getCode());
				request.setAttribute("etudiants", e);

			} else {
				request.setAttribute("etudiants", metier.getAllEtudiant());
				request.setAttribute("filiere", "");
			}
			request.setAttribute("filieres", metier.getAllFiliere());
			request.getRequestDispatcher("searchByFilier.jsp").forward(request, response);
		}
		// ---------------------------------------------------------------------------------------------

		else if (path.equals("/updateFilier.do")) {
			String code = request.getParameter("code");
			request.setAttribute("filiere", metier.getFiliere(code));
			request.getRequestDispatcher("UpdateFilier.jsp").forward(request, response);
		}
		// ---------------------------------------------------------------------------------------------

		else if (path.equals("/saveUpdateFiliere.do")) {
			Filiere f = new Filiere(request.getParameter("code"), request.getParameter("nom"),
					request.getParameter("description"));
			metier.updateFilier(f);
			request.setAttribute("etudiants", metier.getAllEtudiant());
			request.setAttribute("filiere", "");
			request.setAttribute("filieres", metier.getAllFiliere());
			request.getRequestDispatcher("searchByFilier.jsp").forward(request, response);
		}
		// ---------------------------------------------------------------------------------------------

		else if (path.equals("/deleteFilier.do")) {
			String code = request.getParameter("code");
			metier.deleteFilier(code);
			request.setAttribute("etudiants", metier.getAllEtudiant());
			request.setAttribute("filiere", "");
			request.setAttribute("filieres", metier.getAllFiliere());
			request.getRequestDispatcher("searchByFilier.jsp").forward(request, response);
		} // ---------------------------------------------------------------------------------------------
		else if (path.equals("/SearchByetudiant.do")) {
			String Valeur = request.getParameter("valeur");
			if ((Valeur).isEmpty() == false) {

				request.setAttribute("etudiant", metier.getEtudiant(Valeur));
				request.setAttribute("filiere", metier.getFiliereOfEtudiant(Valeur));
			} else {
				request.setAttribute("etudiant", "");
				request.setAttribute("etudiants", metier.getAllEtudiant());
			}
			request.getRequestDispatcher("searchByetudiant.jsp").forward(request, response);
		}
		// ---------------------------------------------------------------------------------------------

		else if (path.equals("/updateEtudiant.do")) {
			String apogee = request.getParameter("apogee");
			Etudiant e  = metier.getEtudiant(apogee);
			request.setAttribute("etudiant", e);
			request.setAttribute("filiere", metier.getFiliereOfEtudiant(e.getCni()));
			request.setAttribute("filieres", metier.getAllFiliere());
			request.getRequestDispatcher("UpdateEtudiant.jsp").forward(request, response);
		}
		// ---------------------------------------------------------------------------------------------

		else if (path.equals("/saveUpdateEtudiant.do")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = sdf.parse(request.getParameter("dateN"));
			} catch (ParseException e1) {
					e1.printStackTrace();
			}

			Etudiant e = new Etudiant(request.getParameter("nom"), request.getParameter("prenom"),
					new java.sql.Date(date.getTime()), request.getParameter("villeN"), request.getParameter("cni"),
					Integer.parseInt(request.getParameter("apogee")), request.getParameter("nationalite"),
					request.getParameter("email"));
			metier.updateEtudiant(e);
			request.setAttribute("etudiant", "");
			request.setAttribute("etudiants", metier.getAllEtudiant());
			request.getRequestDispatcher("searchByetudiant.jsp").forward(request, response);
		}
		// ---------------------------------------------------------------------------------------------

		else if (path.equals("/deleteEtudiant.do")) {
			String apogee = request.getParameter("apogee");
			
			
			metier.deleteEtudiantFromFiliere(metier.getEtudiant(apogee), metier.getFiliereOfEtudiant(apogee));
			metier.deletEtudiant(apogee);
			request.setAttribute("etudiant", "");
			request.setAttribute("etudiants", metier.getAllEtudiant());
			request.getRequestDispatcher("searchByetudiant.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
