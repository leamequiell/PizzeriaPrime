$(document).ready(function () {
    $(document).on("click", ".btn-agregar-pedido", function () {
        let idPizza = $(this).data("id");

        console.log("Agregando pedido con pizza ID:", idPizza);

        Swal.fire({
            title: "¿Agregar esta pizza al pedido?",
            text: "Se registrará un nuevo pedido.",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, agregar"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: "POST",
                    url: contextPath + "/crearPedidoP",
                    data: {
                        idPizza: idPizza  // nombre que el servlet espera
                    },
                    dataType: "json",
                    success: function (response) {
                        if (response.success) {
                            Swal.fire("¡Pedido agregado!", "La pizza fue asociada al pedido.", "success")
                                .then(() => window.location.reload());
                        } else {
                            Swal.fire("Error", "No se pudo agregar el pedido.", "error");
                        }
                    },
                    error: function (err) {
                        console.error("Error al agregar pedido:", err);
                        Swal.fire("Error", "No se pudo crear el pedido.", "error");
                    }
                });
            }
        });
    });
});

