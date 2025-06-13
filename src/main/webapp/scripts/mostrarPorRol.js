document.addEventListener("DOMContentLoaded", function () {
  fetch(contextPath + "/RedirigirporRol")
    .then((res) => res.json())
	.then((data) => {
	  const rol = data.rol;

	  // Cambiar el título
	  if (rol === "admin") {
	    document.title = "Home Admin - Pizzería";
	  } else if (rol === "cocinero") {
	    document.title = "Home Cocina - Pizzería";
	  } else if (rol === "delivery") {
	    document.title = "Home Delivery - Pizzería";
	  } else {
	    document.title = "Home Invitado - Pizzería";
	  }

	  // Mostrar/Ocultar secciones
	  if (rol === "admin") {
	    document.querySelectorAll(".solo-admin").forEach(el => el.style.display = "block");
	    document.querySelectorAll(".solo-cocinero, .solo-delivery").forEach(el => el.style.display = "none");
	  } else if (rol === "cocinero") {
	    document.querySelectorAll(".solo-cocinero").forEach(el => el.style.display = "block");
	    document.querySelectorAll(".solo-admin, .solo-delivery").forEach(el => el.style.display = "none");

	    // Ocultar productos si es cocinero
	    document.getElementById("sec-menus").style.display = "none";

	  } else if (rol === "delivery") {
	    document.querySelectorAll(".solo-delivery").forEach(el => el.style.display = "block");
	    document.querySelectorAll(".solo-admin, .solo-cocinero").forEach(el => el.style.display = "none");

	    // Ocultar productos si es delivery
	    document.getElementById("sec-menus").style.display = "none";
	    document.getElementById("sec").style.display = "none"; // También ocultar mesas

	  } else {
	    document.querySelectorAll(".solo-admin, .solo-cocinero, .solo-delivery").forEach(el => el.style.display = "none");
	    document.title = "Home Invitado - Pizzería";
	  }
	})

});
