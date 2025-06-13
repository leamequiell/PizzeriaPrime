<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sample.core.domain.Mesa"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AREA COCINERO</title>

<!-- Bootstrap y scripts -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/scripts/bootstrap/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/scripts-barcito.js"></script>
<script src="<%=request.getContextPath()%>/scripts/logout.js"></script>
<script src="<%=request.getContextPath()%>/scripts/mesasDisponibles.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>

<script type="text/javascript">
    var contextPath = "<%=request.getContextPath()%>
	";
</script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Pacifico&family=Roboto&display=swap"
	rel="stylesheet">

<style>
body {
	font-family: 'Roboto', sans-serif;
	background-color: #fff8e1;
}

.navbar-brand span {
	font-family: 'Pacifico', cursive;
	font-size: 1.5rem;
	color: #d32f2f !important;
}

.navbar {
	background-color: #333;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
}

.navbar-nav .nav-link {
	color: white !important;
}

.card {
	border-radius: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
	max-width: 400px;
	margin: auto;
}

.card .btn-primary {
	background-color: #ffc107;
	border: none;
	color: #000;
	font-weight: bold;
}

.card .btn-primary:hover {
	background-color: #ff9800;
	color: white;
}

.navbar-light.bg-light, .navbar-light {
	background-color: #fef3e3 !important;
	border-bottom: 2px solid #ffc107;
}

.section-title {
	font-family: 'Pacifico', cursive;
	color: #d32f2f;
	margin-top: 2rem;
	margin-bottom: 1rem;
	font-size: 2rem;
}

.card-title {
	color: #d32f2f;
	font-family: 'Pacifico', cursive;
}

.card-img-top {
	width: 100%;
	height: 250px;
	object-fit: cover;
	padding: 10px;
	background-color: #fff8e1;
	border-top-left-radius: 20px;
	border-top-right-radius: 20px;
}

.card-group.homeitem {
	justify-content: center;
}
</style>
</head>
<body>

	<div class="container-fluid px-4">

		<!-- Navbar -->
		<nav class="navbar navbar-expand-md navbar-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img alt="Brand"
					src="<%=request.getContextPath()%>/icon/food_yellow.png"
					height="30"> <span>Intelio</span>
				</a>

				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#menu">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="menu">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							data-bs-toggle="dropdown">Productos</a>
							<ul class="dropdown-menu bg-secondary">
								<li><a class="dropdown-item" href="#"><img alt="Plato"
										src="<%=request.getContextPath()%>/icon/plato.png"></a></li>
								<li><a class="dropdown-item" href="#"><img alt="Bebida"
										src="<%=request.getContextPath()%>/icon/drink.png"></a></li>
								<li><a class="dropdown-item" href="#"><img alt="Postre"
										src="<%=request.getContextPath()%>/icon/dessert.png"></a></li>
								<li><a class="dropdown-item" href="#"><img alt="Menú"
										src="<%=request.getContextPath()%>/icon/menu.png"></a></li>
							</ul></li>
					</ul>

					<!-- Redes sociales -->
					<ul class="navbar-nav flex-row text-light">
						<li class="nav-item p-2"><i class="bi bi-twitter"></i></li>
						<li class="nav-item p-2"><i class="bi bi-github"></i></li>
						<li class="nav-item p-2"><i class="bi bi-whatsapp"></i></li>
						<li class="nav-item p-2"><i class="bi bi-facebook"></i></li>
					</ul>

					<!-- Logout -->
					<form class="d-flex">
						<button class="btn btn-outline-warning" type="button"
							id="btn-logout">
							<img alt="Logout"
								src="<%=request.getContextPath()%>/icon/logout.png">
						</button>
					</form>
				</div>
			</div>
		</nav>

		<!-- Secciones especiales por rol -->
		<div class="solo-admin" style="display: none;">Botón solo para
			Admin</div>
		<div class="solo-cocinero" style="display: none;">Vista de
			cocina</div>
		<div class="solo-delivery" style="display: none;">Panel de
			delivery</div>

		<script src="<%=request.getContextPath()%>/scripts/mostrarPorRol.js"></script>

		<!-- Mesas -->
		<section id="sec">
			<h2 class="section-title">Mesas</h2>
			<div class="card-group homeitem" id="contenedorMesas"></div>
		</section>

		<!-- Pedidos -->
		<section id="sec-pedidos">
			<h2 class="section-title">Pedidos</h2>
			<div class="recent_order">
				<table class="table table-bordered bg-white">
					<thead class="table-warning text-center">
						<tr>
							<th>Título</th>
							<th>Precio</th>
							<th>Ver detalles</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>test</td>
							<td>test</td>
							<td class="detalles"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</section>

		<!-- Menú principal -->
		<section id="sec-menus">
			<h2 class="section-title">Productos</h2>
			<div class="d-flex flex-wrap justify-content-start"
				id="menu-principal" style="width: 100%; gap: 10px;">
				<div class="card" style="margin-left: 0;">
					<img class="card-img-top"
						src="http://bostonschihuahua.com.mx/wp-content/uploads/2015/09/pizzas-hawaiana-2x.jpg"
						alt="Pizza">
					<div class="card-body">
						<h5 class="card-title">Pizza</h5>
						<p class="card-text">Pizzas disponibles</p>
						<a href="<%=request.getContextPath()%>/LeerDatosPizza"
							class="btn btn-primary">Ir</a>
					</div>
				</div>
			</div>
		</section>



	</div>

	<script
		src="<%=request.getContextPath()%>/scripts/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
