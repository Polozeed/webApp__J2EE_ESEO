<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<meta charset="ISO-8859-1">
<title>Connexion</title>
<link rel="stylesheet" type="text/css" href="style.css">

<body>

<c:set var="x" value="0"></c:set>
	<c:forEach items="${cartlist }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>

	<%@include file="topbar.jsp" %>

	<div class="signup-header">
	 	<h2>Se connecter à <mark>E-Commerce Eseo</mark></h2>
	</div>

	 <form method="post" action="Controller">
	 <input type="hidden" name="page" value="login-form">
		 <font color="#F24638"><c:out value="${msg }"></c:out></font>
	 	<div class="signup-group">
	 		<label>Identifiant</label>
	 		<input type="text" name="username" placeholder="Identifiant" value="<c:out value="${username }"></c:out>">
	 	</div>
	 	<div class="signup-group">
	 		<label>Mot de passe</label>
	 		<input type="password" name="password" placeholder="Mot de passe">
	 	</div>
	 	<div class="signup-group">
	 		<button type="submit" name="login" class="signup-btn">Se connecter</button>
	 	</div>
	 	<p>
	 		Pas encore inscrit ? <a href="Controller?page=sign-up" style="color:#F24638;">Créer un compte</a>
	 	</p>
	 </form>
	<br><br><br>
	<%@include file="bottombar.jsp" %>

</body>
</html>