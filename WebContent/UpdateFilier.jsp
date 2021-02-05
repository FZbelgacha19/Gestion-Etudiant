<%@page import="org.netbeans.modules.schema2beansdev.SchemaRep.Include"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Modifier Filiere</title>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
		<br> <br>
	</div>
	<c:set var="f" value="${filiere}"/>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<form action="saveUpdateFiliere.do" method="POST">
			<div class="form-group row">
				<label class="col-sm-4">Code filiere</label>
				<div class="col-sm-8">
					<input name="code" class="form-control" type="text"
						placeholder="Tapez code filiere" value="${f.getCode()}" readonly>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4">Nom filiere</label>
				<div class="col-sm-8">
					<input name="nom" class="form-control" type="text"
						placeholder="Tapez le nom filiere ex : SMI" value="${f.getNom()}">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-4">Description</label>
				<div class="col-sm-8">
					<input name="description" class="form-control" type="text"
						placeholder="Ecrire un discription" value="${f.getDescription()}">
				</div>
			</div>
			<div class="float-right">
			<button type="submit" class="btn btn-outline-primary">Enregistre</button>
			<button class="btn btn-outline-danger"
				onclick="location.replace('http://localhost:8080/GestionEtudiant/SearchByFiliere.do?value=${f.getNom()}')">Annuler</button>
			</div>
		</form>
	</div>
<%@include file="footer.jsp"%>
</body>
</html>