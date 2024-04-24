<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="model.Compte" %>
<%@page import="dao.CompteDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des comptes</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
    }
    .user-display {
        text-align: right;
        padding: 10px;
        background-color: #f3f3f3;
        display: flex;
        justify-content: flex-end;
        align-items: center;
    }
    .logout-button, .view-matieres-button {
        background-color: #007bff;
        color: white;
        padding: 5px 10px;
        margin-left: 10px;
        text-decoration: none;
        border-radius: 5px;
        font-size: 14px;
        cursor: pointer;
    }
    .logout-button {
        background-color: red;
    }
    .account-list, .matiere-list {
        margin-bottom: 20px;
        flex-grow: 1;
    }
    .account-item, .matiere-item {
        border-bottom: 1px solid #ccc;
        padding: 10px;
        margin-bottom: 10px;
        display: flex;
        align-items: center;
    }
    .account-item:last-child, .matiere-item:last-child {
        border-bottom: none;
    }
    .account-actions, .matiere-actions {
        margin-left: auto;
    }
    .account-actions i, .matiere-actions i {
        margin-right: 10px;
        cursor: pointer;
    }
    .add-button {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 8px;
    }
</style>
</head>
<body>

<div class="user-display">
    Connecté en tant que : <strong><%= session.getAttribute("loggedInUser") != null ? session.getAttribute("loggedInUser") : "Guest" %></strong>
    <% if (session.getAttribute("loggedInUser") != null) { %>
        <a href="${pageContext.request.contextPath}/Deconnexion" class="logout-button">Déconnexion</a>
        <a href="${pageContext.request.contextPath}/ListeMatiere" class="view-matieres-button">Voir les matières</a>
    <% } %>
</div>

<h1>Liste des comptes</h1>
<a href="${pageContext.request.contextPath}/Ajout" class="add-button"><i class="fas fa-plus"></i> Ajouter un nouveau compte</a>
<div class="account-list">
    <% 
    ArrayList<Compte> comptes = CompteDAO.getAll();
    for (Compte compte : comptes) {
    %>
    <div class="account-item">
        <div><strong>Identifiant :</strong> <%= compte.getLogin() %></div>
        <div class="account-actions">
            <i class="fas fa-edit" onclick="location.href='Modifier?id=<%=compte.getId()%>'" title="Modifier"></i>
            <i class="fas fa-trash-alt" onclick="if(confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?')) location.href='Supprimer?id=<%=compte.getId()%>'" title="Supprimer"></i>
        </div>
    </div>
    <% } %>
</div>

</body>
</html>
