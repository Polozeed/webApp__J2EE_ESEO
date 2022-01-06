<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des produits</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%@include file="topbarAdmin.jsp" %>

	
	<div class="container">
	<h2>Liste des produits :</h2>
		 <table>
			<tr>
			<th style="width: 100px;text-align: center">Nom</th>
			<th style="width: 100px;text-align: center">Prix</th>
			<th style="width: 100px;text-align: center">Catégorie</th>
			<th style="width: 100px;text-align: center">Image</th>
			<th style="width: 100px;text-align: center">Editer</th>
			<th style="width: 100px;text-align: center">Supprimer</th>
		</tr>
	</table>

		 <c:forEach items="${list }" var="row">

		  <table style="table-layout: fixed;width: 100%;">
		  	
				<tr>
					<td style="width: 100px;text-align: center"><c:out value="${row.nom }"></c:out></td>
					<td style="width: 100px;text-align: center"><c:out value="${row.prix }"></c:out></td>
					<td style="width: 100px;text-align: center"><c:out value="${row.categorie}"/></td>
					<td style="width: 100px;text-align: center"><img src="${row.image}" height="100" width="150" ></td>
					<td style="width: 100px;text-align: center"><a href="<%= request.getContextPath() %>/admin?page=edit&id=${row.id}" style="color: #6bb1f8;">Editer</a></td>
					<td style="width: 100px;text-align: center"><a href="<%= request.getContextPath() %>/admin?page=delete&id=${row.id}" style="color:#6bb1f8;">Supprimer</a></td>
				</tr>
			</table>
		 </c:forEach>
		 </div>
	<%@include file="../bottombar.jsp" %>
	
</body>
</html>