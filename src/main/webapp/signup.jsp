<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<c:set var="x" value="0"></c:set>
	<c:forEach items="${cartlist }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>

	<%@include file="topbar.jsp" %>
	
	<div class="signup-header">
	 	<h2>S'inscrire sur Vendredi Noir</h2>
	 </div>

<!--// Formulaire d'inscription -->
	 <form method="post" action="Controller">
	 <input type="hidden" name="page" value="sign-up-form">
	 	<span style="color: #F24638; "><c:out value="${msg }"></c:out></span>
	 	<div class="signup-group">
	 		<label>Nom</label>
	 		<input type="text" name="name" placeholder="Nom" value="<c:out value="${firstname }"></c:out>" required>
	 	</div>
		 <div class="signup-group">
			 <label>Prénom</label>
			 <input type="text" name="name" placeholder="Prénom" value="<c:out value="${name }"></c:out>" required>
		 </div>
	 	<div class="signup-group">
	 		<label>Email</label>
	 		<input type="email" name="email" placeholder="Adresse email" value="<c:out value="${email }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Identifiant</label>
	 		<input type="text" name="username" placeholder="Identifiant" value="<c:out value="${username }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Adresse de livraison</label>
	 		<input type="text" name="address" placeholder="Adresse" value="<c:out value="${address }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Mot de passe</label>
	 		<input type="password" name="password_1" placeholder="Entrer votre mot de passe" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Confirmer le mot de passe</label>
	 		<input type="password" name="password_2" placeholder="Confirmer le mot de passe" required>
	 	</div>
	 	<div class="signup-group">
	 		<button type="submit" name="register" class="signup-btn">S'inscrire</button>
	 	</div>
	 	<p>
	 		Déja un compte ? <a href="Controller?page=login" style="color:#F24638;">Se connecter</a>
	 	</p>
	 </form>
	<br><br><br>
	<%@include file="bottombar.jsp" %>

</body>
</html>