<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceuil</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>

<c:set var="x" value="0"></c:set>
	<c:forEach items="${cartlist }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>

	<%! String nomMenu = "home-decor"; %>

	<%@include file="../topbar.jsp" %>
	
	<div class="tiazon-content">
 	<div class="container">
 		<div class="row">
				<%@include file="menu.jsp" %>

 				<div class="col-md-8"><!-- right -->
 					<h2 style="text-align: center;">Electronique</h2>

					<!-- Trie appelé sur les jsp du menu -->
					<h5>Trier par prix :</h5>
					<form action="Controller" method="get" style="border: none;margin:0px;padding: 0px;margin-bottom: 20px;">
						<input type="hidden" name="page" value="price-sort">
						<input type="hidden" name="action" value="home-decor">
						<select name="sort">
							<option value="low-to-high">Croissant</option>
							<option value="high-to-high">Décroissant</option>
						</select>
						<input type="submit" value="Valider">
					</form>

					<c:forEach items="${list }" var="product">

						<c:if test="${product.getCategorie() == 'Electronique' }">
							<!-- Afficher les produits correspondant au menu sélectionné -->
							<div class="col-md-4">
								<img src="${product.getImage() }" class="img-responsive" >
								<br>
								<div class="text-center"><a style="color: black;"><c:out value="${product.getNom() }"></c:out></a></div>
								<c:if test="${product.getQuantite() <= 0}">
									<p style="text-align: center;"> Produit Indisponible</p>
									<p style="text-align: center;"> <c:out value="${ product.getPrix() } €"></c:out></p>
									<c:choose>
										<c:when test="${session == null}">
											<div class="text-center">
												<a class="btn btn-danger ">Indisponible</a>
											</div>
										</c:when>
										<c:when test="${session != null}">
											<div class="text-center">
												<a class="btn btn-danger">Indisponible</a>
											</div>
										</c:when>
									</c:choose>
								</c:if>

								<c:if test="${product.getQuantite() > 0}">
									<p style="text-align: center;"> <c:out value="Quantité disponible: ${ product.getQuantite() } "></c:out></p>
									<p style="text-align: center;"> <c:out value="${ product.getPrix() } €"></c:out></p>
									<c:choose>
										<c:when test="${session == null}">
											<div class="text-center">
												<a class="btn btn-primary" href="Controller?page=login"/>Ajouter</a>
											</div>
										</c:when>
										<c:when test="${session != null}">
											<div class="text-center">
												<a class="btn btn-primary" href="Controller?page=addtocart&action=index&id=<c:out value="${product.getId()}"/>">Ajouter</a>
											</div>
										</c:when>
									</c:choose>
								</c:if>

								<br>
							</div>

						</c:if>


					</c:forEach>
 					
 				</div>
 			</div>
 		</div>
 	</div>


	<%@include file="../bottombar.jsp" %>
	
</body>
</html>