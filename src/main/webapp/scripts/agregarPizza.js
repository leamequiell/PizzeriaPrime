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
                title: "Desea agregar una Pizza?",
                text: "Confirma que desea agregar la nueva Pizza!",
                icon: "warning",
                showCancelButton: true,
                confirmButtonText: "Si, deseo agregrarla!",
                cancelButtonText: "No, cancelar!",
                reverseButtons: true
              }).then((result) => {
                if (result.isConfirmed) {
                   //si confirmamos lanzamos la peticion ajax.
                   
                   $.ajax({
                    url: contextPath + '/CrearPizza',
                    dataType: 'json',
                    success: function (data) {
                        Swal.fire({
                            position: "Se agrego la Pizza",
                            icon: "success",
                            title: "La pizza nueva se agrego correctamente",
                            showConfirmButton: true,
                            timer: 3000
                          }).then((response)=>{
                            if (result.isConfirmed) {
                                window.location.href=contextPath+'/LeerDatosPizza';
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