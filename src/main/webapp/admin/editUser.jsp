<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Editer User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@include file="topbarAdmin.jsp" %>

<div class="signup-header">
    <h2>Voulez vous bloquer le compte utilisateur ?</h2>
</div>

<form method="post" action="admin">

    <input type="hidden" name="page" value="edit_user">
    <input type="hidden" name="id" value="<c:out value="${u.getId() }"/>">


    <div class="signup-group">
        <label>Nom: ${u.getLogin()} </label>

    </div>
    <div class="signup-group">
        <label>Prenom: ${u.getPrenom() }</label>
    </div>
    <div class="signup-group">
        <label>Bloquer l'utilisateur</label>
        <input type="checkbox" id="bloque" name="bloque" value="bloque" checked>
    </div>

    <div class="signup-group">
        <input type="submit" value="Process">
    </div>
</form>

<%@include file="../bottombar.jsp" %>
</body>
</html>
