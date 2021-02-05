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
<title>Recherche Filiere</title>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
		<br> <br>
	</div>
	<div class="panel-body">
		<div
			class="d-flex justify-content-center align-items-center container">
			<form class="form-inline" action="SearchByFiliere.do" method="POST">
				<label class="mr-sm-4">Rechercher</label>
				<!-- <input name="valeur"
					class="form-control mr-sm-4" type="search" placeholder="Search"
					aria-label="Search"> -->
				<select class="form-control mr-sm-4" name="valeur" required>
					<c:forEach items="${filieres}" var="f">
						<option value="${f.getCode()}">${f.getNom()}</option>

					</c:forEach>
				</select>
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</div>
	<br>
	<div class="container col-md-12 col-md-offset-2">
		<c:set var="filier" value="${filiere}" />
		<c:set var="ListEtudiant" value="${etudiants}" />

		<c:if test="${filier!=''}">
			<div
				class="container border border-dark rounded col-md-4 col-md-offset-2 ">
				<br>
				<h3>Information du filiere</h3>
				<div class="form-group row">
					<h5 class="col-sm-4">Code :</h5>
					<b>${filier.getCode()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-4">Nom :</h5>
					<b>${filier.getNom()}</b>
				</div>
				<div class="form-group row">
					<h5 class="col-sm-4">Description :</h5>
					<b> ${filier.getDescription()}</b>
				</div>
				<div class="float-right">
					<a class="btn btn-outline-primary btn-sm"
						href="updateFilier.do?code=${filier.getCode()}">Modifier</a>
					<c:if test="${fn:length(ListEtudiant)==0}">
						<a class="btn btn-outline-danger btn-sm"
							href="deleteFilier.do?code=${filier.getCode()}">Supprime</a>
					</c:if>
				</div>
				<br> <br>
			</div>
		</c:if>

	</div>


	<br>
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
<%@include file="footer.jsp"%>
</body>
</html>