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
<title>Bienvenue</title>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
		<br> <br>
	</div>
	<div class="text-center font-italic" style="color: darkgray; margin-top: 50px;">
	<h1 class="display-3">Bienvenue</h1><br>
	<h2 class="display-3">Dans votre espace</h2><br>
	<h3 class="display-4">Gestion des etudiants et leurs filieres</h3>
	</div>
<%@include file="footer.jsp"%>
</body>
</html>