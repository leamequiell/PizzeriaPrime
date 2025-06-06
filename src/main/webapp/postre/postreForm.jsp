<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de postre</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.7/dist/loadingoverlay.min.js"></script>

<script type="text/javascript">
	var contextPath = '<%= request.getContextPath() %>';
</script>

<script src="<%=request.getContextPath()%>/scripts/agregarPostre.js">
	
</script>
</head>
<body>
	<div class = "container">
		<form class="form" id="formPostre">
		<div class="form-group">
			<label for="exampleInputEmail1">Titulo</label> <input type="text"
				class="form-control" id="titulo" name="titulo"
				aria-describedby="emailHelp" placeholder="Ingrese un titulo">
		</div>

		<div class="form-group">
			<label for="exampleInputPassword1">Precio</label> <input type="text"
				class="form-control" id="precio" name="precio"
				aria-describedby="emailHelp" placeholder="Ingrese un precio">
		</div>

		<div class="form-group">
			<label for="exampleInputPassword1">Descripcion</label> <input
				type="text" class="form-control" id="descripcion" name="descripcion"
				aria-describedby="emailHelp" placeholder="Ingrese una descripcion">
		</div>

		<button type="button" class="btn btn-primary" id="btn-confirmar">Submit</button> <!-- lleva al agregarPostre.js para crear un postre -->
	</form>
	</div>

</body>
</html>