<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sample.core.domain.Mesa"%>
    
<!DOCTYPE html>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="<%=request.getContextPath()%>/scripts/bootstrap/css/bootstrap.min.css" >
	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/scripts/scripts-barcito.js"></script>
	<script src="<%=request.getContextPath()%>/scripts/logout.js"></script>
	<script src="<%=request.getContextPath()%>/scripts/mesasDisponibles.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  	<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
	<script type="text/javascript">
			var contextPath="<%=request.getContextPath()%>";
	</script>

	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

	<!--<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" >-->
    <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	<meta charset="ISO-8859-1">
	<title>Insert title here</title>

	
	-->
	
	
</head>	
<body>



<div class="container">

	
      <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container-fluid">
        <!-- icono o nombre -->

        <a class="navbar-brand" href="#">
          <img alt="Brand" src="<%=request.getContextPath()%>/icon/food_yellow.png">
          <span class="text-warning">Intelio</span>

        </a>
            
        <!-- boton del menu -->

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

          <!-- elementos del menu colapsable -->

        <div class="collapse navbar-collapse" id="menu">
          <ul class="navbar-nav me-auto">
            <li class="nav-item">	
              <a class="nav-link active" aria-current="page" href="#">Home</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Productos
              </a>

              <ul class="dropdown-menu bg-secondary" aria-labelledby="navbarDropdown">
                <li>
					<a class="dropdown-item" href="#">
						<img alt="Brand" src="<%=request.getContextPath()%>/icon/plato.png">
					</a>
				</li>
				<li>
					<a class="dropdown-item" href="#">
						<img alt="Brand" src="<%=request.getContextPath()%>/icon/drink.png">
					</a>
				</li>
                <li>
					<a class="dropdown-item" href="#">
						<img alt="Brand" src="<%=request.getContextPath()%>/icon/dessert.png">
					</a>
				<li>   
                <li>
					<a class="dropdown-item" href="#">
						<img alt="Brand" src="<%=request.getContextPath()%>/icon/menu.png">
					</a>
				</li>
              </ul>
            </li>
          </ul>

          <hr class="d-md-none text-white-50">

           <!-- enlaces redes sociales -->

          <ul class="navbar-nav  flex-row flex-wrap text-light">

           <li class="nav-item col-6 col-md-auto p-3">
                <i class="bi bi-twitter"></i>
                <small class="d-md-none ms-2">Twitter</small>  
            </li>

            <li class="nav-item col-6 col-md-auto p-3">
              <i class="bi bi-github"></i>
              <small class="d-md-none ms-2">GitHub</small> 
            </li>

            <li class="nav-item col-6 col-md-auto p-3">
              <i class="bi bi-whatsapp"></i>
              <small class="d-md-none ms-2">WhatsApp</small>
            </li>

            <li class="nav-item col-6 col-md-auto p-3">
              <i class="bi bi-facebook"></i>
              <small class="d-md-none ms-2">Facebook</small>
            </li>

          </ul>
          
         <!--boton Informacion -->

          <form class="d-flex">
            <button class="btn btn-outline-warning d-none d-md-inline-block " type="button" id="btn-logout">
				<img alt="Brand" src="<%=request.getContextPath()%>/icon/logout.png">
			</button>
          </form>
          
          
        </div>
     
        </div>  
      </nav>

	<section id="sec">
		<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="#">Mesas</a>
		</nav>
		<div class="card-group homeitem mt-4"  id="contenedorMesas"></div>
	</section>

	<section id="sec-pedidos">
	     <nav class="navbar navbar-light bg-light mt-4">
			  <a class="navbar-brand" href="#">Pedidos</a>
		</nav>
		<div class="recent_order">				
				<table id="boxPedidosSolicitados">
					<thead>
						<tr>
							<th width="25%" class="center">Titulo</th>
							<th width="12%" class="center">Precio</th>
							<th width="12%" class="center">Ver detalles</th>
						</tr>
					</thead>
					<tbody>
					<tr class="">
							<td width="25%" class="titulo">test</td>
							<td width="12%" class="precio">test</td>
							<td width="12%" class="detalles"></td>
					</tr>
					
					</tbody>
				</table>
				
		</div>
	</section>

	<section id="sec-menus">
		<nav class="navbar navbar-light bg-light mt-4">
			<a class="navbar-brand" href="#">Productos</a>
		</nav>
		<div class="card-group homeitem mt-4" id="menu-principal">
			<div class="card m-2" >
				<img class="card-img-top" src="https://cdn.pixabay.com/photo/2023/05/31/11/15/fish-8031138_960_720.jpg" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Plato</h5>
					<p class="card-text">Platos disponibles</p>
					<a href="<%= request.getContextPath()%>/LeerDatosPlato" class="btn btn-primary">Ir</a>
				</div>
			</div>
			
			<div class="card m-2" >
				<img class="card-img-top" src="https://cdn.pixabay.com/photo/2023/05/31/11/15/fish-8031138_960_720.jpg" alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Pizza</h5>
					<p class="card-text">Pizzas disponibles</p>
					<a href="<%= request.getContextPath()%>/LeerDatosPizza" class="btn btn-primary">Ir</a>
				</div>
			</div>
			
		</div>
	</section>

</div>


   
 <script src="<%=request.getContextPath()%>/scripts/bootstrap/js/bootstrap.bundle.min.js" ></script>
			
</body>
</html>