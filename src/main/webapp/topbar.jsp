<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://kit.fontawesome.com/e23d203d3a.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/e23d203d3a.js" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<!-- Topbar appelée sur chaque jsp -->




<header>
<nav class="navbar navbar-expand-lg navbar-light custom-bg">
    <div class="container-fluid">
        <a class="navbar-brand" style="font-size: 38px;line-height: 20px;" href="index.jsp">Vendredi Noir</a>     <!-- old href ==> "#" -->
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 text-center" style="margin-left: 33%; float: right;">
                <li> <a href="Controller?page=index">Accueil</a></li>
                <c:choose>
                <c:when test="${session == null}">
                <li><a href="Controller?page=login">Se connecter</a></li>
                <li><a href="Controller?page=sign-up">S'inscrire</a></li>
                <li> <a href="Controller?page=login" ><i  class="fas fa-shopping-cart fa-2x" style="color: white;width: auto; padding: 5px"></i>(<c:out value="${x}"/>)</a>
                    </c:when>
                    <c:when test="${session != null}">
                <li><a href="Controller?page=logout" style="color: #F24638;">Se déconnecter</a></li>
                <li><a href="Controller?page=compte">Mon Compte</a></li>
                <li> <a href="Controller?page=showcart" ><i  class="fas fa-shopping-cart fa-2x" style="color: white;width: auto; padding: 5px"></i>(<c:out value="${x}"/>)</a>

                    </c:when>
                    </c:choose>
                    <a href="admin" ><i  class="fas fa-users-cog fa-2x" style="color: white; padding: 9px; margin-left: 40px"></i></a>

            </ul>

        </div>
    </div>
</nav>


