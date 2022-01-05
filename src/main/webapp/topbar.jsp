<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="style.css">
<!-- Topbar appelée sur chaque jsp -->
<header>
    <h1>
        E-Commerce Eseo
    </h1>
    <nav>
        <ul>
            <li><a href="Controller?page=index">Accueil</a></li>
            <c:choose>
                <c:when test="${session == null}">
                    <li><a href="Controller?page=login">Se connecter</a></li>
                    <li><a href="Controller?page=sign-up">S'inscrire</a></li>
            <li> <a href="Controller?page=showcart" ><i  class="fas fa-shopping-cart" style="color: white;width: auto; padding: 5px"></i>(<c:out value="${x}"/>)</a>
                </c:when>
                <c:when test="${session != null}">
                    <li><a href="Controller?page=logout" style="color: #F24638;">Se déconnecter</a></li>
                    <li><a href="Controller?page=compte">Mon Compte</a></li>
                    <li><a href="Controller?page=showcart">Panier (<c:out value="${x}"/>)</a></li>
                </c:when>
            </c:choose>
            <li><a href="admin">Se connecter en administrateur</a></li>
        </ul>
    </nav>
</header>
