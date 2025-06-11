document.addEventListener("DOMContentLoaded", function () {
  fetch(contextPath+"/rolActual")
    .then((res) => res.json())
    .then((data) => {
      const rol = data.rol;

      if (rol === "admin") {
        document.querySelectorAll(".solo-admin").forEach(el => el.style.display = "block");
        document.querySelectorAll(".solo-cocinero, .solo-delivery").forEach(el => el.style.display = "none");
      } else if (rol === "cocinero") {
        document.querySelectorAll(".solo-cocinero").forEach(el => el.style.display = "block");
        document.querySelectorAll(".solo-admin, .solo-delivery").forEach(el => el.style.display = "none");
      } else if (rol === "delivery") {
        document.querySelectorAll(".solo-delivery").forEach(el => el.style.display = "block");
        document.querySelectorAll(".solo-admin, .solo-cocinero").forEach(el => el.style.display = "none");
      } else {
        // Si no hay sesión o no está logueado, ocultamos todo
        document.querySelectorAll(".solo-admin, .solo-cocinero, .solo-delivery").forEach(el => el.style.display = "none");
      }
    })
    .catch((err) => {
      console.error("Error al obtener el rol:", err);
    });
});
