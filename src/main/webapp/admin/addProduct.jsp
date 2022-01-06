<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un produit</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<%@include file="topbarAdmin.jsp" %>
	
	<div class="signup-header">
	 	<h2>Ajouter un produit</h2>
	 </div>

	 <form method="post" action="admin">
	 
	 <input type="hidden" name="page" value="add_product">
     
	 	<div class="signup-group">
	 		<label>Nom</label>
	 		<input type="text" name="nom" placeholder="Ajouter un nom"  required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Prix</label>
	 		<input type="text" name="prix" placeholder="Prix du produit" required>
	 	</div>
	 	<div class="signup-group">
			<label>Categorie</label>
			<select name="select-categorie" id="select-categorie" required>
				<option value="Téléphones">Téléphones</option>
				<option value="Ordinateurs portables">Ordinateurs portables</option>
				<option value="Vêtements">Vêtements</option>
				<option value="Electronique">Electronique</option>
			</select>
	 	</div>
		 <div class="signup-group">
			 <label>Quantité en stock</label>
			 <input type="text" name="quantite" placeholder="Quantite en stock" pattern="[0-9]" required>
		 </div>
	 	<div class="signup-group">
	 		<label>En tendance</label>
			<select name="select-tendance" id="select-tendance" required>
				<option value="Oui">Oui</option>
				<option value="Non">Non</option>
			</select>
	 	</div>
	 	<div class="signup-group">
	 		 <label for="fileupload"> Selectionner une image à importer</label>
	 		<input type="file" name="image"><br>
	 	</div>
	 	<div class="signup-group">
			<input type="submit" value="Valider">
		</div>
	 </form>

	<%@include file="../bottombar.jsp" %>
</body>
</html>