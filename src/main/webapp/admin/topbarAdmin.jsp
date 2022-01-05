<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://kit.fontawesome.com/e23d203d3a.js" crossorigin="anonymous"></script>
<!-- Topbar pour l'admin appelée sur chaque jsp le concernant-->
<header>
    <h1>
        Administrateur
    </h1>
    <nav>
        <ul>
            <li><a href="admin?page=index">Accueil</a></li>
            <li><a href="admin?page=addproduct">Ajouter un produit</a></li>
            <li><a href="admin?page=listeUtilisateur">Liste Utilisateur</a></li>
            <li><a href="Controller?page=logout">Se déconnecter</a></li>
        </ul>
    </nav>
</header>