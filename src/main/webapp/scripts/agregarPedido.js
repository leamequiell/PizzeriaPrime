function agregarPedidoP(data) {
	let id = $(data).attr("data-id");
	let tipo = $(data).attr("data-tipo");

	Swal.fire({
		title: "¿Estás seguro de agregar el nuevo plato?",
		text: "Se agregará un nuevo registro al pedido.",
		icon: "warning",
		showCancelButton: true,
		confirmButtonColor: "#3085d6",
		cancelButtonColor: "#d33",
		confirmButtonText: "¡Sí, agregar!"
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				type: "post",
				url: contextPath + "/agregarPedidoP?idProducto=" + id + "&estadoPizza=" + tipo,
				dataType: "json",
				success: function(response) {
					Swal.fire({
						title: "¡Agregado!",
						text: "El nuevo plato se agregó correctamente.",
						icon: "success"
					});
					window.location.href = contextPath + "/pizza/pizzaPage";
				},
				error: function(err) {
					console.error("Error al agregar pedido:", err);
				}
			});
		}
	});
}

