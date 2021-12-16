<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../style.css">

<!-- Afficher les produits correspondant au menu sélectionné -->
<div class="col-md-4">
    <img src="${product.getImage() }" class="img-responsive" >
    <br>
        <div class="text-center"><a style="color: black;"><c:out value="${product.getNom() }"></c:out></a></div>
        <p style="text-align: center;"> <c:out value="${ product.getPrix() } €"></c:out></p>
        <c:choose>
            <c:when test="${session == null}">
                <div class="text-center">
                    <a class="btn btn-primary" href="Controller?page=login"/>Ajouter</a>
                </div>
            </c:when>
            <c:when test="${session != null}">
                <div class="text-center">
                    <a class="btn btn-primary" href="Controller?page=addtocart&action=clothing&id=<c:out value="${product.getId()}"/>">Ajouter</a>
                </div>
            </c:when>
        </c:choose>
    <br>
</div>