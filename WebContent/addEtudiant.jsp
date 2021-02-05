<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Ajouter Etudiant</title>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
		<br> <br>
	</div>
 <main role="main" class="container">
	<div class="container col-md-8 col-md-offset-2 col-xs-12"
		style="font-size: large;">
		<form action="saveEtudiant.do" method="POST">

			<div class="form-group row">
				<label class="col-sm-4 col-form-label">CNI</label>
				<div class="col-sm-8">
					<input name="cni" class="form-control" type="text"
						placeholder="Tapez Code national d'identité" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Apogee</label>
				<div class="col-sm-8">
					<input name="apogee" class="form-control" type="number"
						placeholder="Tapez le code apogee" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Nom</label>
				<div class="col-sm-8">
					<input name="nom" class="form-control" type="text"
						placeholder="entrer nom" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Prenom</label>
				<div class="col-sm-8">
					<input name="prenom" class="form-control" type="text"
						placeholder="entrer prenom" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Date Naissance</label>
				<div class="col-sm-8">
					<input name="dateN" class="form-control" type="date" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">Ville naissance</label>
				<div class="col-sm-8">
					<input name="villeN" class="form-control" type="text"
						placeholder="Ex : kenitra" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">nationalite</label>
				<div class="col-sm-8">
					<input name="nationalite" class="form-control" type="text"
						placeholder="Ex : maroc" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">email</label>
				<div class="col-sm-8">
					<input name="email" class="form-control" type="email"
						placeholder="Ex : exemple@gmail.com" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4 col-form-label">filiere</label>
				<div class="col-sm-8">
					<select class="form-control" name="filiere" required>
						<option selected disabled>Choisie filiere</option>
						<c:forEach items="${filieres}" var="f">
							<option value="${f.getCode()}">${f.getNom()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="float-right">
				<button type="submit" class="btn btn-outline-primary">Ajouter</button>
				<button class="btn btn-outline-danger"
					onclick="location.replace('http://localhost:8080/GestionEtudiant/addEtudiant.do');">Annuler</button>
			</div>
		</form>
	</div>
</main>	
<%@include file="footer.jsp"%>
	
</body>
</html>