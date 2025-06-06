$(function() {

    $("#btn-confirmar").click(function (e) {
            e.preventDefault(); 
            var titulo =$("#titulo").val();
            var precio =$("#precio").val();
            var descripcion =$("#descripcion").val();

            //creamos una constante , (variable)
            const swalWithBootstrapButtons = Swal.mixin({
                customClass: {
                  confirmButton: "btn btn-success",
                  cancelButton: "btn btn-danger"
                },
                buttonsStyling: false
              });


              swalWithBootstrapButtons.fire({
                title: "desea agregar el plato?",
                text: "confirma que desea agregar el nuevo plato!",
                icon: "warning",
                showCancelButton: true,
                confirmButtonText: "Yes, deseo agregrarlo!",
                cancelButtonText: "No, cancelar!",
                reverseButtons: true
              }).then((result) => {
                if (result.isConfirmed) {
                   //si confirmamos lanzamos la peticion ajax.
                   
                   $.ajax({
                    url: contextPath + '/CrearPlato',
                    dataType: 'json',
                    success: function (data) {
                        Swal.fire({
                            position: "Se agrego el plato",
                            icon: "success",
                            title: "El plato nuevo se agrego correctamente",
                            showConfirmButton: true,
                            timer: 3000
                          }).then((response)=>{
                            if (result.isConfirmed) {
                                window.location.href=contextPath+'/LeerDatosPlato';
                            }
                          })
                    },
                    error: function(xhr, status, error) {
                          alert(error);               
                    },
                    data: {
                        titulo: titulo,
                        precio: precio,
                        descripcion: descripcion
                    },
                    cache: true,
                    type: 'post'
                });
                
                } else if (
                  /* Read more about handling dismissals below */
                  result.dismiss === Swal.DismissReason.cancel
                ) {
                  swalWithBootstrapButtons.fire({
                    title: "Cancelado",
                    text: "Se cancelo la operacion :)",
                    icon: "error"
                  });
                }
              });

        });

});