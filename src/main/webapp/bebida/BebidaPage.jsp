<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>

<%@page import="java.util.*"%>
  <%@page import="com.sample.core.domain.Bebida"%>
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<%  List<Bebida> bebidas  =  (List) request.getAttribute("bebidas"); %>

<div class="container">

<span>
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/formulario?form=bebidaform" > Nuevo </a>
</span>

<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">precio</th>
      <th scope="col">Descripcion</th>
      <th scope="col">operaciones</th>
    </tr>
  </thead>
  <tbody>
<%for(int i=0;i<bebidas.size();i++){
	%>
	 
	<tr bgcolor="white">
	<td><%=bebidas.get(i).getId() %></td>
	<td><%=bebidas.get(i).getPrecio()%></td>
	<td><%=bebidas.get(i).getDescripcion()%></td>
	<td> 
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/loadBebidaForm?id=<%=bebidas.get(i).getId()%>" > editar </a>
	 	<button class="btn btn-danger"> eliminar </button>
	 	<button class="btn btn-danger"> Agregar a pedido </button>
	 </td>
<%		
}
%>
 </tbody>

</table>


</div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>