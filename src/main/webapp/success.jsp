
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
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
	
	<c:choose>
		<c:when test="${x == 0}">
				<%
				request.getRequestDispatcher("cart.jsp").forward(request, response);
				%>
		</c:when>

		<c:when test="${bloque== true}">
			<div class="container" style="margin-top: 60px;margin-bottom: 60px;">
				<h4>Merci mais votre compte est bloqué. Vous pouvez contacter les équipes supports à l'adresse email suivante :
					<font color="#6bb1f8">supportEcommerce@reseau.eseo.fr</font>
					<br>Nous vous remercions par avance !</h4>
			</div>
		</c:when>

		<c:when test="${session != null}">
				<div class="container" style="margin-top: 60px;margin-bottom: 60px;">
					<h4>Merci <font color="#6bb1f8"><c:out value="${login }"></c:out></font> d'avoir passé commande. Vous serez livré à <font color="#6bb1f8"><c:out value="${adress }"></c:out></font> en 3 jours ouvrés. </h4>
					<br><br>
					<a href="Controller?page=index"><input type="button" value="Poursuivre mes achats" style="width:100%;padding:8px;font-size:16px;"></a>
				</div>


			<div>
				<a href="Controller?page=pdf" style="color: #000000">Télécharger la facture PDF</a>
			</div>

		</c:when>
	
	</c:choose>
	<%@include file="bottombar.jsp" %>

</body>
</html>