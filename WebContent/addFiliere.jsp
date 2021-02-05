<%@page import="org.netbeans.modules.schema2beansdev.SchemaRep.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Ajouter Filiere</title>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
		<br> <br>
	</div>

	<div class="container col-md-8 col-md-offset-2 col-xs-12" style="font-size: large;">
		<form action="saveFiliere.do" method="POST">
			<div class="form-group row">
				<label class="col-sm-4">Code filiere</label>
				<div class="col-sm-8">
					<input name="code" class="form-control" type="text"
						placeholder="Tapez code filiere" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4">Nom filiere</label>
				<div class="col-sm-8">
					<input name="nom" class="form-control" type="text"
						placeholder="Tapez le nom filiere ex : SMI" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4">Description</label>
				<div class="col-sm-8">
					<input name="description" class="form-control" type="text"
						placeholder="Ecrire un discription">
				</div>
			</div>
			<div class="float-right">
			<button type="submit" class="btn btn-outline-primary">Ajouter</button>
			<button class="btn btn-outline-danger"
				onclick="location.replace('http://localhost:8080/GestionEtudiant/addFiliere.do');">Annuler</button>
		</div>
		</form>
	</div>

<%@include file="footer.jsp"%>
</body>
</html>