<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion Admin</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<%@include file="topbarAdmin.jsp" %>

	<div class="signup-header">
	 	<h2> <mark>Connexion</mark> Admin</h2>
	</div>

<form method="post" action="admin">
	 
	 <input type="hidden" name="page" value="admin-login-form">
	 
	 	<!-- Validations errors -->
	 	<font color="#F24638"><c:out value="${msg }"></c:out></font>
	 
	 	<div class="signup-group">
	 		<label>Identifiant</label>
	 		<input type="text" name="username" placeholder="Votre identifiant" value="<c:out value="${username }"></c:out>">
	 	</div>
	 	<div class="signup-group">
	 		<label>Mot de passe</label>
	 		<input type="password" name="password" placeholder="Votre mot de passe">
	 	</div>
	 	<div class="signup-group">
	 		<button type="submit" name="Se connecter" class="signup-btn">Se connecter</button>
	 	</div>
	 </form>
<br>
	<br>
	<%@include file="../bottombar.jsp" %>
</body>
</html>