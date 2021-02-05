<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Modifier Etudiant</title>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
		<br>
		<br>
	</div>

	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<form action="saveUpdateEtudiant.do" method="POST">
		<c:set var="e" value="${etudiant}"/>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">CNI</label> 
				 <div class="col-sm-8"><input name="cni"
					class="form-control" type="text" placeholder="Tapez Code national d'identité"
					value="${e.getCni()}"></div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Apogee</label> 
				 <div class="col-sm-8"><input
					name="apogee" class="form-control" type="number"
					placeholder="Tapez le code apogee" value="${e.getApogee()}" readonly></div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Nom</label> 
				 <div class="col-sm-8"><input
					name="nom" class="form-control" type="text"
					placeholder="entrer nom" value="${e.getNom()}"></div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Prenom</label> 
				 <div class="col-sm-8"><input
					name="prenom" class="form-control" type="text"
					placeholder="entrer prenom" value="${e.getPrenom()}"></div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Date Naissance</label> 
				 <div class="col-sm-8"><input
					name="dateN" class="form-control" type="date" value="${e.getDateNaissance()}"></div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Ville naissance</label> 
				 <div class="col-sm-8"><input
					name="villeN" class="form-control" type="text" placeholder="Ex : kenitra" value="${e.getVilleNaissance()}"></div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">nationalite</label> 
				 <div class="col-sm-8"><input
					name="nationalite" class="form-control" type="text" placeholder="Ex : maroc" value="${e.getNationalite()}"></div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">email</label> 
				 <div class="col-sm-8"><input
					name="email" class="form-control" type="email" placeholder="Ex : exemple@gmail.com" value="${e.getEmail()}"></div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">filiere</label> 
				 <div class="col-sm-8">
				 <select class="form-control" name="valeur" required>
				 <option value="${filiere.getCode()}">${filiere.getNom()}</option>
				 <c:forEach items="${filieres}" var="f">
				 	<c:if test="${filiere.getNom() != f.getNom()}">
				 	<option value="${f.getCode()}">${f.getNom()} </option>
				 	</c:if>
				 	
				 </c:forEach>
				 </select>
				 </div>
			</div>
			<div class="float-right">
			<button type="submit" class="btn btn-outline-primary">Entregistre</button>
			<button class="btn btn-outline-danger" onclick="location.replace('http://localhost:8080/GestionEtudiant/searchByetudiant.do?value=${e.getCni()}');">Annuler</button>
		</div>
		</form>
	</div>
<%@include file="footer.jsp"%>
</body>
</html>