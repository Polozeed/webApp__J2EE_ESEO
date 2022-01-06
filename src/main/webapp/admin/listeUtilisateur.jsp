<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Liste des utilisateurs</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@include file="topbarAdmin.jsp" %>


<div class="container">
  <h2>Liste des utilisateurs :</h2>
  <table>
    <tr>

      <th>Login</th>
      <th>Nom</th>
      <th>Prénom</th>
      <th>Adresse de livraison</th>
      <th>Compte bloqué</th>
      <th>Option</th>

    </tr>
  </table>

  <c:forEach items="${listUser }" var="row">
    <table style="table-layout: fixed;width: 100%;">
      <tr>
        <td style="width: 100px;text-align: center"><c:out value="${row.login }"></c:out></td>
        <td style="width: 100px;text-align: center"><c:out value="${row.nom }"></c:out></td>
        <td style="width: 100px;text-align: center"><c:out value="${row.prenom}"/></td>
        <td style="width: 100px;text-align: center"><c:out value="${row.adresse}"/></td>
        <td style="width: 100px;text-align: center"><c:out value="${row.affichage_bloquerDebloquer()}"/></td>
        <td style="width: 100px;text-align: center"><a href="<%= request.getContextPath() %>/admin?page=editUser&id=${row.login}" style="color:#6bb1f8;">Bloquer le compte</a></td>
      </tr>
    </table>
  </c:forEach>
</div>
<%@include file="../bottombar.jsp" %>

</body>
</html>