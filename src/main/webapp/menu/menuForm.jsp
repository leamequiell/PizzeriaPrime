<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

	<script type="text/javascript">
			var contextPath='<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/scripts/menu-script.js"> </script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

	</head>
	<body>
	
		<div class="container mt-4" >
			
		<h1>Menu</h1>
		<form class="form" id="menuForm">
		<div class="form-group" >
		    <label>Tipo de menu</label>
		      <select  class="form-control" id="cmbTipoMenu">
		        <option selected>Choose...</option>
		        <option>Dia</option>
		        <option>Estudiantil</option>
		        <option>Ejecutivo</option>
		      </select>
		  </div>
		
		<div class="form-group" id="input-plato">
		    <label>Plato</label>
		      <select  class="form-control" id="cmbPlato">
		        <option selected>Choose...</option>
		      </select>
		</div>
		<div class="form-group" id="input-postre">
		    <label>Postre</label>
		      <select class="form-control" id="cmbPostre">
		        <option selected>Choose...</option>
		      </select>
		</div>
		<div class="form-group" id="input-bebida">
		    <label>Bebida</label>
		      <select class="form-control" id="cmbBebida">
		        <option selected>Choose...</option>
		      </select>
		</div>
		
		  <div class="form-group" id="menuForm">
		    <label>Titulo</label>
		    <input type="text" class="form-control" id="titulo" name="titulo" aria-describedby="emailHelp" placeholder="Enter titulo">
		  </div>
		  <div class="form-group">
		    <label>Descripcion</label>
		    <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Enter description">
		  </div>
		  <div class="form-group">
		    <label>Precio</label>
		    <input type="text" class="form-control" id="precio" name="precio" aria-describedby="emailHelp" placeholder="Enter price">
		  </div>
		  <button type="button" class="btn btn-primary" id="btn-crear-menu">Submit</button>
		

		</form>
		
		</div>
			
	</body>
</html>