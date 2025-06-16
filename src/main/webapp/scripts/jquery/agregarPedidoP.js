function agregarPedidoP(data) {
    const id = $(data).attr("data-id");
    const tipo = $(data).attr("data-tipo"); // ¡Ojo! Asegúrate de que exista este atributo

    Swal.fire({
        title: "¿Estás seguro de agregar esta pizza?",
        text: "Se agregará un nuevo producto al pedido.",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "¡Sí, agregar!"
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                type: "POST",
                url: contextPath + "/abrirPedidoP"+id+'&idTipo='+tipo,
                data: {
                    idProducto: id,
                    estadoPizza: tipo
                },
                dataType: "json",
                success: function (response) {
                    Swal.fire({
                        title: "¡Agregado!",
                        text: response.mensaje || "El producto fue agregado exitosamente.",
                        icon: "success"
                    }).then(() => {
                        // Recarga la página o redirige si lo necesitás
                        window.location.href = contextPath + "/";
                    });
                },
                error: function () {
                    Swal.fire({
                        title: "Error",
                        text: "No se pudo agregar el producto.",
                        icon: "error"
                    });
                }
            });
        }
    });
}
