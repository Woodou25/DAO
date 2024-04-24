<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier le compte</title>
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
        .form-group input, .submit-button {
            padding: 5px;
            font-size: 14px;
            margin: 5px 0;
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
        <a href="${pageContext.request.contextPath}/Deconnexion" class="logout-button">Déconnexion</a>
</div>

<div class="container">
    <h2>Modifier le compte</h2>
    <form action="${pageContext.request.contextPath}/Modifier" method="post">
        <input type="hidden" name="id" value="${compte.id}">
        <div class="form-group">
            <label for="login">Identifiant :</label>
            <input type="text" id="login" name="login" required value="${compte.login}">
        </div>
        
        <div class="form-group">
            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" required value="${compte.password}">
        </div>
        
        <input type="submit" value="Modifier" class="submit-button">
    </form>
</div>

</body>
</html>
