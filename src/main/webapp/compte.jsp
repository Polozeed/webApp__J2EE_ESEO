<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Information compte</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<c:set var="x" value="0"></c:set>
<c:forEach items="${cartlist }" var="i">
  <c:set var="x" value="${x+1 }"></c:set>
</c:forEach>

<%@include file="topbar.jsp" %>

<div class="signup-header">
  <h2>Information du compte</h2>
</div>

<form method="post" action="Controller">

  <input type="hidden" name="page" value="compte-form">

  <div class="signup-group">
    <label>Identifiant</label>
    <input type="text" name="username" placeholder="Identifiant" value="<c:out value="${username }"></c:out>">
  </div>

  <div class="signup-group">
    <label>Nom</label>
    <input type="text" name="firstname" placeholder="Nom" value="<c:out value="${firstname }"></c:out>">
    <label>Prénom</label>
    <input type="text" name="name" placeholder="Prénom" value="<c:out value="${name }"></c:out>">
  </div>
  <div class="signup-group">

  </div>
  <div class="signup-group">
    <label>Email</label>
    <input type="email" name="email" placeholder="Adresse email" value="<c:out value="${email }"></c:out>">
  </div>

  <div class="signup-group">
    <label>Adresse de livraison</label>
    <input type="text" name="address" placeholder="Adresse" value="<c:out value="${address }"></c:out>">
  </div>



  <div class="te">
    <button type="submit" name="majInfo" class="signup-btn" >Mettre à jour les informations</button>

  </div>

</form>
<br>
<div>
  <a href="Controller?page=historique"><input type="submit" value="Consulter votre historique des commandes" class="btn btn-success" style="width:100%;padding:8px;font-size:16px;"></a><br>
  <a href="Controller?page=changement-mdp"><input type="submit" value="Changer votre Mot de passe" class="btn btn-success" style="width:100%;padding:8px;font-size:16px;"></a><br>
</div>

<br>
<%@include file="bottombar.jsp" %>


</body>
</html>