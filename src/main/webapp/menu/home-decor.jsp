<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="../style.css">
</head>
<body>

<c:set var="x" value="0"></c:set>
	<c:forEach items="${cartlist }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>

	<%@include file="../topbar.jsp" %>
	
	<div class="tiazon-content">
 	<div class="container">
 		<div class="row">
				<%@include file="menu.jsp" %>

 				<div class="col-md-8"><!-- right -->
 					<h2 style="text-align: center;">Décoration d'intérieurs</h2><br>

					<%@include file="trie.jsp" %>
 					
 					<c:forEach items="${list }" var="product">
 						
 						<c:if test="${product.getCategorie() == 'home decor' }">
 							
		 					<div class="col-md-4">
		 						<img src="${product.getImage() }" class="img-responsive" ><br>
		 						<div class="text-center"><a style="color: black;"><c:out value="${product.getNom() }"></c:out></a></div>
		 						<p style="text-align: center;"> <c:out value="${ product.getPrix() } €"></c:out></p>
								<div class="text-center">  <a class="btn btn-primary" href="Controller?page=addtocart&action=home-decor&id=<c:out value="${product.getId()}"/>">Ajouter</a> </div><br>		 					</div>
 							
 						</c:if>
 						
 						
 					</c:forEach>
 					
 				</div>
 			</div>
 		</div>
 	</div>


	<%@include file="../bottombar.jsp" %>
	
</body>
</html>