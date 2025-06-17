	           <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
	      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
	      crossorigin="anonymous">

	<!-- Fuente divertida tipo pizzería -->
	<link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Roboto&display=swap" rel="stylesheet">

	<style>
		body {
		    height: 100vh;
		    margin: 0;
		    display: flex;
		    justify-content: center;  /* Centrar horizontalmente */
		    align-items: center;      /* Centrar verticalmente */
		    font-family: 'Roboto', sans-serif;
		    background-color: #fff3e0; /* Fondo cálido */
		}

		.container {
		    background-color: rgba(255, 255, 255, 0.95);
		    padding: 30px;
		    border-radius: 30px;
		    max-width: 400px;
		    width: 100%;
		    box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
		    color: #333;
		}

		h1 {
		    font-family: 'Pacifico', cursive;
		    color: #d32f2f;
		    text-align: center;
		    margin-bottom: 25px;
		}

		label {
		    font-weight: bold;
		}

		.btn-pizza {
		    background-color: #ffc107;
		    color: #000;
		    border: none;
		    width: 100%;
		}

		.btn-pizza:hover {
		    background-color: #ff9800;
		    color: white;
		}
	</style>

	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.7/dist/loadingoverlay.min.js"></script>

	<script type="text/javascript">
		var contextPath = '<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/scripts/login.js"></script>
</head>

<body>
	<div class="container">
		<h1>Ingresar Usuario</h1>
		<form class="form" id="Login">
			<div class="form-group">
				<label for="usuario">Usuario</label>
				<input type="text" class="form-control" id="usuario" name="usuario" placeholder="Ingresa tu usuario">
			</div>
			<div class="form-group">
				<label for="password">Contraseña</label>
				<input type="password" class="form-control" id="password" name="password" placeholder="Ingresa tu contraseña">
			</div>
<!-- ... código anterior igual ... -->
        <button type="button" class="btn btn-pizza" id="btn-login">Entrar 🍕</button>
        <button type="button" class="btn btn-pizza mt-3" onclick="irComoInvitado()">Entrar como visitante 👤</button>
    </form>
</div>

<script type="text/javascript">
    function irComoInvitado() {
        window.location.href = contextPath + "/home/home.jsp";
    }
</script>
</body>
</html>
