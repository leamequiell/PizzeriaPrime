<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="java.util.*"%>
<%@page import="com.sample.core.domain.Postre"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Lista Postres</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

	<script type="text/javascript">
			var contextPath='<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/scripts/eliminarPostre.js"> </script>


</head>
<body>

<div class="container mt-4">


<span>
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/formulario?form=postreForm" > Nuevo </a> <!--lleva al formulario -->
</span>

<%  List<Postre> postres  = (List) request.getAttribute("postres"); %> <!-- Obtiene la lista de platos -->

<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Titulo</th>
      <th scope="col">Precio</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Operaciones</th>
    </tr>
  </thead>
  <tbody>
  
  <!-- Recorre la lista para poner los datos en la tabla -->
<%for(int i=0;i<postres.size();i++){
	%>
	 
	<tr bgcolor="white">
	<td><%=postres.get(i).getId() %></td>
	<td><%=postres.get(i).getTitulo() %></td>
	<td><%=postres.get(i).getPrecio()%></td>
	<td><%=postres.get(i).getDescripcion()%></td>
	<td> 
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/loadPostreForm?id=<%=postres.get(i).getId()%>" > editar </a> <!-- lleva a LoadBebidaForm para editar un dato -->
	 	<button class="btn btn-danger"  data-id="<%=postres.get(i).getId()%>"  onClick="myFunction(this)" > eliminar </button> <!-- lleva a un js para eliminar -->
	 </td>
<%		
}
%>
 </tbody>

</table>

</div>
</body>
</html>