
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Vendredi Noir</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>



<header>
    <h1>
        PDF
    </h1>
    <nav>
        <ul>
            <li><a href="Controller?page=index">Accueil</a></li>
            <c:choose>
                <c:when test="${session == null}">
                    <li><a href="Controller?page=login">Connexion</a></li>
                    <li><a href="Controller?page=sign-up">Inscription</a></li>
                </c:when>
                <c:when test="${session != null}">
                    <li><a href="Controller?page=logout" style="color: #F24638;">Déconnexion</a></li>
                    <li><a href="#">My Account(<c:out value="${username }"></c:out>)</a></li>
                </c:when>
            </c:choose>
            <li><a href="Controller?page=showcart">cart(<c:out value="${x}"/>)</a></li>
        </ul>
    </nav>
</header>



<c:choose>
    <c:when test="${session == null}">
        <%
            request.getRequestDispatcher("login.jsp").forward(request, response);
        %>
    </c:when>

    <c:when test="${session != null}">
        <div class="container" style="margin-top: 60px;margin-bottom: 60px;">
            <h4>Salut C'est la page pdf</h4>
        </div>
    </c:when>

</c:choose>

<footer style="position: fixed;bottom: 0;left: 0;width: 100%;">
    <div class="footer"> &copy; 2018 Copyright:
        <a href="Controller?page=index"> E-commerce-ESEO.com</a>
    </div>
</footer>
</body>
</html>