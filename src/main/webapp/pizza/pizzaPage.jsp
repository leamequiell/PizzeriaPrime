<%@page import="com.sample.core.domain.Pizza"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de Pizzas</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
      crossorigin="anonymous">

<!-- Fuente divertida tipo pizzería -->
<link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Roboto&display=swap" rel="stylesheet">

<style>
	body {
	    font-family: 'Roboto', sans-serif;
	    background-color: #fff8e1;
	    padding: 20px;
	}
	h1, h2 {
	    font-family: 'Pacifico', cursive;
	    color: #d32f2f;
	}

	.container {
	    background-color: rgba(255, 255, 255, 0.95);
	    padding: 30px;
	    border-radius: 20px;
	    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
	}
	.table {
	    background-color: #fff;
	    border-radius: 15px;
	    overflow: hidden;
	    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}

	.btn-primary {
	    background-color: #ffc107;
	    color: #000;
	    border: none;
	}

	.btn-primary:hover {
	    background-color: #ff9800;
	    color: white;
	}

	.btn-danger {
	    background-color: #d32f2f;
	    border: none;
	}

	.btn-danger:hover {
	    background-color: #b71c1c;
	}

	.btn-warning {
	    color: #000;
	    border: none;
	}

	.modal-content {
	    border-radius: 20px;
	    background-color: #fff8e1;
	}
</style>

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/scripts/formPizza.js"></script>
<script src="<%=request.getContextPath()%>/scripts/agregarPizza.js"></script>
<script src="<%=request.getContextPath()%>/scripts/agregarPedido.js"></script>
<script src="<%=request.getContextPath()%>/scripts/eliminarPizza.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript">
	var contextPath = '<%=request.getContextPath()%>';
</script>
</head>

<body>
<div class="container mt-4">
	<h1>Pizzas Disponibles</h1>

	<!-- Botón Nuevo -->
	<div class="mb-3">
		<a class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">➕ Nueva Pizza</a>
	</div>

	<% List<Pizza> pizzas  = (List) request.getAttribute("pizzas"); %>

	<!-- Tabla -->
	<table class="table table-bordered text-center">
		<thead class="table-warning">
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>Precio</th>
				<th>Descripcion</th>
				<th>Operaciones</th>
			</tr>
		</thead>
		<tbody>
		<% for(Pizza pizza : pizzas) { %>
			<tr>
				<td><%= pizza.getId() %></td>
				<td><%= pizza.getTitulo() %></td>
				<td>$<%= pizza.getPrecio() %></td>
				<td><%= pizza.getDescripcion() %></td>
				<td>
					<a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/loadPizzaForm?id=<%=pizza.getId()%>">Editar</a>
					<button class="btn btn-danger btn-sm" data-id="<%=pizza.getId()%>" onClick="myFunction(this)">Eliminar</button>
					<button class="btn btn-warning btn-sm agregarPedido" data-id="<%=pizza.getId()%>" onClick="agregarPedido(this)">Agregar a pedido</button>
				</td>
			</tr>
		<% } %>
		</tbody>
	</table>
</div>

<!-- Modal Nueva Pizza -->
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content p-4">
			<h2 class="text-center">Nueva Pizza</h2>
			<form id="formPizza">
				<div class="form-group">
					<label for="titulo">Titulo</label>
					<input type="text" class="form-control" id="titulo" name="titulo" placeholder=" ">
				</div>
				<div class="form-group">
					<label for="descripcion">Descripcion</label>
					<input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="">
				</div>
				<div class="form-group">
					<label for="precio">Precio</label>
					<input type="text" class="form-control" id="precio" name="precio" placeholder="">
				</div>
				<button type="button" class="btn btn-primary btn-block" id="btn-confirmar">Guardar</button>
			</form>
		</div>
	</div>
</div>

<!-- Scripts Bootstrap -->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

</body>
</html>
