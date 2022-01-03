<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panier</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<c:set var="x" value="0"></c:set>
	<c:forEach items="${cartlist }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>

	<%@include file="topbar.jsp" %>
	
	<div class="container">
	
	<c:choose> 
		<c:when test="${x == 1}">
						<h4 style="margin-top: 40px;">Mon panier (<c:out value="${x}"/> produit)</h4>
		</c:when>
		<c:when test="${x > 1}">
						<h4 style="margin-top: 40px;">Mon panier (<c:out value="${x}"/> produits)</h4>
		</c:when>
		<c:otherwise >
				<h4 style="margin-top: 40px;">Mon panier est vide !</h4>
		</c:otherwise>
	
	</c:choose>
	<table>
		<tr>
			<th>Nom du produit</th>
			<th>Prix</th>
			<th>Quantité</th>
			<th>Catégorie</th>
			<th>Supprimer produit</th>
		</tr>
	</table>
	
		<c:set var="total" value="0"></c:set>
		<c:forEach items="${cartlist }" var="i">
			<c:forEach items="${list }" var="Product">
				<c:if test="${i == Product.getId() }">
				
				<c:set var="total" value="${total + Product.getPrix() }"></c:set>
				
			<table style="table-layout: fixed;width: 100%;">
				<tr>
					<td style="width: 100px;"><img src="${Product.getImage()}" height="100" width="150" >  (<c:out value="${Product.getNom()}"/>)</td>
					<td style="width: 50px;"><c:out value="${Product.getPrix()}"/></td>
					<td style="width: 100px;"><c:out value="${Product.getQuantite()}"/></td>
					<td style="width: 100px;"><a href="Controller?page=remove&id=<c:out value="${Product.getId()}"/>"><span class="btn btn-danger">X</span></a></td>
				</tr>
			</table>
				</c:if>
			</c:forEach>
		</c:forEach>
	
	<h4 style="margin-top: 40px;margin-bottom: 40px;">Prix total : <c:out value="${ total}"></c:out> €</h4>
	
	<a href="Controller?page=success"><input type="submit" value="Finaliser la commande" class="btn btn-success" style="width:100%;padding:8px;font-size:16px;"></a><br>
	<a href="Controller?page=index"><input type="button" value="Poursuivre mes achats" class="btn btn-warning" style="width:100%;padding:8px;font-size:16px;"></a>
	
	
	</div>

	<%@include file="bottombar.jsp" %>

</body>
</html>