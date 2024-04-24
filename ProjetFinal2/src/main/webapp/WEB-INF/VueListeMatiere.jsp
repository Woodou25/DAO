<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="model.Matiere"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Matières</title>
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
        .logout-button {
            background-color: red;
            color: white;
            padding: 5px 10px;
            margin-left: 10px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 14px;
        }
        .matiere-list {
            padding: 20px;
        }
        .matiere-item {
            border-bottom: 1px solid #ccc;
            padding: 10px;
            display: flex;
            align-items: center;
        }
        .matiere-item:last-child {
            border-bottom: none;
        }
        .matiere-actions {
            margin-left: auto;
        }
        .matiere-actions i {
            margin-right: 10px;
            cursor: pointer;
        }
        .add-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 8px;
            display: inline-block;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="user-display">
    Connecté en tant que : <strong>${sessionScope.loggedInUser != null ? sessionScope.loggedInUser : "Guest"}</strong>
        <a href="${pageContext.request.contextPath}/Deconnexion" class="logout-button">Déconnexion</a>
</div>

<h1>Liste des Matières</h1>
<a href="${pageContext.request.contextPath}/AjoutMatiere" class="add-button"><i class="fas fa-plus"></i> Ajouter une nouvelle matière</a>
    <div class="matiere-item${status.last ? ' last' : ''}">
        <div><strong>ID :</strong> ${matiere.id}</div>
        <div><strong>Nom :</strong> ${matiere.nom}</div>
        <div class="matiere-actions">
            <a href="${pageContext.request.contextPath}/ModifierMatiere?id=${matiere.id}"><i class="fas fa-edit" title="Modifier"></i></a>
            <a href="${pageContext.request.contextPath}/SupprimerMatiere?id=${matiere.id}" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette matière ?');"><i class="fas fa-trash-alt" title="Supprimer"></i></a>
        </div>
    </div>
</body>
</html>
