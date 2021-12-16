<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../style.css">

<!-- Trie appelé sur les jsp du menu -->
<<h5>Trier par prix :</h5>
<form action="Controller" method="get" style="border: none;margin:0px;padding: 0px;margin-bottom: 20px;">
    <input type="hidden" name="page" value="price-sort">
    <input type="hidden" name="action" value="mobiles">
    <select name="sort">
        <option value="low-to-high">Croissant</option>
        <option value="high-to-high">Décroissant</option>
    </select>
    <input type="submit" value="Valider">
</form>