<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Historique</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<c:set var="x" value="0"></c:set>
<c:forEach items="${cartlist }" var="i">
    <c:set var="x" value="${x+1 }"></c:set>
</c:forEach>

<%@include file="topbar.jsp" %>

<div class="container">
    <table>
        <tr>
            <th style=" text-align:center">Date de la commande</th>
            <th style="text-align:center">Nom du produit</th>
            <th style="text-align:center">Prix</th>
            <th style="text-align:center">Quantité</th>
            <th style="text-align:center">Catégorie</th>
        </tr>
    </table>

    <c:set var="total" value="0"></c:set>
    <c:forEach items="${historique}" var="Hist">
        <c:forEach items="${list }" var="Product">
            <c:if test="${Hist.getId_produit() == Product.getId() }">
                <c:set var="total" value="${total + Product.getPrix() }"></c:set>
                <table style="table-layout: fixed;width: 100%;">
                    <tr>
                        <td style="width: 100px;text-align: center"><c:out value="${Hist.getDateheureFront()}"/></td>
                        <td style="width: 140px;text-align: center"><img src="${Product.getImage()}" height="100" width="150" >  (<c:out value="${Product.getNom()}"/>)</td>
                        <td style="width: 40px;text-align: center"><c:out value="${Product.getPrix()}"/></td>
                        <td style="width: 70px;text-align: center"><c:out value="${Hist.getQuantite()}"/></td>
                        <td style="width: 70px;text-align: center"><c:out value="${Product.getCategorie()}"/></td>
                    </tr>
                </table>
            </c:if>
        </c:forEach>
    </c:forEach>
    <h4 style="margin-top: 40px;margin-bottom: 40px;">Prix total : <c:out value="${ total}"></c:out> €</h4>
</div>

<%@include file="bottombar.jsp" %>

</body>
</html>