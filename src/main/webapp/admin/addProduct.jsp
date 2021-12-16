<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<%@include file="topbarAdmin.jsp" %>
	
	<div class="signup-header">
	 	<h2>Add Product</h2>
	 </div>

	 <form method="post" action="admin">
	 
	 <input type="hidden" name="page" value="add_product">
     
	 	<div class="signup-group">
	 		<label>Name</label>
	 		<input type="text" name="nom" placeholder="product name goes here"  required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Price</label>
	 		<input type="text" name="prix" placeholder="product price" required>
	 	</div>
	 	<div class="signup-group">
			<label>Categorie modif</label>
			<input type="text" name="categorie"  required>
	 	</div>
	 	
	 	<div class="signup-group">
	 		<label>Featured</label>
	 		<input type="text" name="quantite" placeholder="yes/no" required>
	 	</div>
	 	<div class="signup-group">
	 		 <label for="fileupload"> Select an image to upload</label>
	 		<input type="file" name="image" required><br>
	 	</div>
	 	<div class="signup-group">
			<input type="submit" value="Process">	 
		</div>
	 </form>

	<%@include file="../bottombar.jsp" %>
</body>
</html>