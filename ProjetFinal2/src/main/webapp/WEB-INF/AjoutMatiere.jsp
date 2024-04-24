<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Matière</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .header {
            text-align: right;
            padding: 10px;
            background-color: #f3f3f3;
        }
        .container {
            padding: 20px;
        }
        .form-group {
            margin-bottom: 10px;
        }
        .form-group label {
            margin-right: 10px;
        }
        .form-group input {
            padding: 5px;
            font-size: 14px;
        }
        .submit-button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
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
    </style>
</head>
<body>

<div class="header">
    Connecté en tant que : <strong>${sessionScope.loggedInUser != null ? sessionScope.loggedInUser : "Guest"}</strong>
    <% if (session.getAttribute("loggedInUser") != null) { %>
        <a href="${pageContext.request.contextPath}/Deconnexion" class="logout-button">Déconnexion</a>
    <% } %>
</div>

<div class="container">
    <h2>Ajouter une nouvelle matière</h2>
    <form action="AjoutMatiere" method="post">
        <div class="form-group">
            <label for="nom">Nom de la matière :</label>
            <input type="text" name="nom" required>
        </div>
        <input type="submit" value="Ajouter" class="submit-button">
    </form>
</div>
</body>
</html>
