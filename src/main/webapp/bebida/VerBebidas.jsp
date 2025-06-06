<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="/CSS/estilos-ver.css">
    <title>Ver Bebidas</title>
  
</head>
<body class="cuerpo">
    <div class="contenedor">
        <header class="encabezado">
            <h1 class="titulo">Listado de bebidas</h1>
            <p class="descripcion">Bebidas</p>
        </header>

        <section class="productos">
            <% 
               
                ResultSet conjuntoResultados = (ResultSet) request.getAttribute("conjuntoResultados");

                
      

                if (conjuntoResultados != null) {
                    while (conjuntoResultados.next()) {
                        
         
                        String titulo = conjuntoResultados.getString("titulo");
                        int precio = conjuntoResultados.getInt("precio");
                        String descripcion = conjuntoResultados.getString("descripcion");
                       
            %>
            <!-- Mostrar el producto -->
            <article class="producto">
                <h2 class="titulo-producto">Bebida: <%= titulo %></h2>
                <p class="precio-producto">precio: <%= precio %></p>
                <p class="descripcion-producto">Descripcion: <%= descripcion %></p>
            </article>
            <% 
                    }
                }
            %>
        </section>

<a href="/LoadBebidaForm" class="boton-volver">Volver a Inicio</a>
    </div>
</body>
</html>
