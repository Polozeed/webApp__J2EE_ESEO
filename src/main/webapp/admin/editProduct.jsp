<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editer un produit</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%@include file="topbarAdmin.jsp" %>
	
	<div class="signup-header">
	 	<h2>Editer un produit</h2>
	 </div>

	 <form method="post" action="admin">
	 
	 <input type="hidden" name="page" value="edit_product">
	 <input type="hidden" name="id" value="<c:out value="${p.getId() }"/>">
	 <input type="hidden" name="categorie" value="<c:out value="${p.getCategorie() }"/>">
	 <input type="hidden" name="tendance" value="<c:out value="${p.getEnTendance() }"/>">
     
	 	<div class="signup-group">
	 		<label>Nom</label>
	 		<input type="text" name="nom" value="<c:out value="${p.getNom() }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Prix (€)</label>
	 		<input type="number" name="prix" value="<c:out value="${p.getPrix() }"></c:out>" required>
	 	</div>


	 	<div class="signup-group">
	 		<label>Catégorie</label>
			<select name="select-categorie" id="select-categorie" required>
				<option value="CategorieDefaut">${p.getCategorie()}</option>
				<option value="Telephones">Téléphones</option>
				<option value="Ordinateurs portables">Ordinateurs portables</option>
				<option value="Vetements">Vêtements</option>
				<option value="Electronique">Electronique</option>
			</select>
	 	</div>
	 	
	 	<div class="signup-group">
	 		<label>Quantité</label>
	 		<input type="number" name="quantite" value="<c:out value="${p.getQuantite() }"></c:out>" required>
	 	</div>

		 <div class="signup-group">
			 <label>En tendance</label>
			 <select name="select-tendance" id="select-tendance" required>
				 <option value="TendanceDefaut">${p.getEnTendance()}</option>
				 <option value="oui">Oui</option>
				 <option value="non">Non</option>
			 </select>
		 </div>

	 	<div class="signup-group">
	 		<label>Image</label>
	 		<img   style="height: 160px;width: 160px;" src="<c:out value="${p.getImage() }"></c:out>">
			<br>
			<input type="text" name="image" value="<c:out value="${p.getImage() }"></c:out>" >
	 	</div>
	 	<div class="signup-group">
			<input type="submit" value="Valider">
		</div>
	 </form>

	<br>
	<br>
	<%@include file="../bottombar.jsp" %>
</body>
</html>