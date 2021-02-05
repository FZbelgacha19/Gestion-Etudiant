<%@page import="org.netbeans.modules.schema2beansdev.SchemaRep.Include"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Recherche Etudiant</title>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
		<br> <br>
	</div>
	<div class="panel-body">
		<div
			class="d-flex justify-content-center align-items-center container">
			<form class="form-inline" action="SearchByetudiant.do" method="POST">
				<label class="mr-sm-4">Rechercher</label> <input name="valeur"
					class="form-control mr-sm-4" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</div>
	<br>
	<div class="container col-md-12 col-md-offset-2">
		<c:set var="etud" value="${etudiant}" />
		<c:set var="ListEtudiant" value="${etudiants}" />

		<c:if test="${etud!=''}">
			<div
				class="container border border-dark rounded col-md-8 col-md-offset-2 ">
				<br>
				<h3>Information Etudiant</h3>
				<div class="form-group row">
					<h5 class="col-sm-8">Apogee :</h5>
					<b>${etud.getApogee()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-8">CNI :</h5>
					<b>${etud.getCni()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-8">Nom :</h5>
					<b>${etud.getNom()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-8">Prenom :</h5>
					<b>${etud.getPrenom()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-8">Date Naissance :</h5>
					<b>${etud.getDateNaissance()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-8">Ville Naissance :</h5>
					<b>${etud.getVilleNaissance()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-8">Nationalite :</h5>
					<b>${etud.getNationalite()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-8">Email :</h5>
					<b>${etud.getEmail()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-8">Filiere :</h5>
					<b>${filiere.getNom()}</b>
				</div>
				<div class="float-right">
					<a class="btn btn-outline-primary btn-sm"
						href="updateEtudiant.do?apogee=${etud.getApogee()}">Modifier</a> <a
						class="btn btn-outline-danger btn-sm"
						href="deleteEtudiant.do?apogee=${etud.getApogee()}">Supprime</a>

				</div>
				<br> <br>
			</div>
		</c:if>

	</div>


	<br>
	<c:if test="${etud==''}">
		<div class="container col-md-12 col-md-offset-2">
			<table class="table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>Apogee</th>
						<th>CNI</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Date Naissance</th>
						<th>Ville Naissance</th>
						<th>Nationalite</th>
						<th>Email</th>
						<th>action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${ListEtudiant}">
						<tr>
							<td>${e.getApogee()}</td>
							<td>${e.getCni()}</td>
							<td>${e.getNom()}</td>
							<td>${e.getPrenom()}</td>
							<td>${e.getDateNaissance()}</td>
							<td>${e.getVilleNaissance()}</td>
							<td>${e.getNationalite()}</td>
							<td>${e.getEmail()}</td>
							<td><a class="btn btn-outline-primary btn-sm"
								href="updateEtudiant.do?apogee=${e.getApogee()}">Modifier</a> <a
								class="btn btn-outline-danger btn-sm"
								href="deleteEtudiant.do?apogee=${e.getApogee()}">Supprime</a></td>
						<tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</c:if>

<%@include file="footer.jsp"%>
</body>
</html>