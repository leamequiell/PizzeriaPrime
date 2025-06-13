<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Acceso Denegado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8d7da;
            font-family: 'Arial', sans-serif;
        }
        .denegado-container {
            margin-top: 100px;
        }
    </style>
</head>
<body>
    <div class="container text-center denegado-container">
        <div class="alert alert-danger" role="alert">
            <h1 class="display-4">⛔ Acceso Denegado</h1>
            <p class="lead">No tienes permiso para acceder a esta sección del sistema.</p>
            <hr>
            <p>Si crees que esto es un error, por favor contacta con un administrador.</p>
            <a href="<%= request.getContextPath() %>/login.jsp" class="btn btn-primary">Volver al inicio</a>
        </div>
    </div>
</body>
</html>
