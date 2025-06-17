function myFunction(data){

    

    value =  $(data).attr("data-id");

    

    //agregamos sweet alert

    Swal.fire({

        title: "Esta seguro de eliminar la Pizza?",

        text: "La pizza asera eliminada de la base!",

        icon: "warning",

        showCancelButton: true,

        confirmButtonColor: "#3085d6",

        cancelButtonColor: "#d33",

        confirmButtonText: "Si, borrar!"

      }).then((result) => {

        if (result.isConfirmed) {

            //agregamos ajax

            $.ajax({

                type: "get",

                url: contextPath+"/PizzaEliminar?id="+value,

                dataType: "json",

                success: function (response) {

                    //agregamos sweet alert

                    Swal.fire({

                        title: "Eliminado!",

                        text: "La pizza se elimino correctamente.",

                        icon: "success",

                        showConfirmButton: true,

                      }).then(response =>{

                        if (response.isConfirmed) {

                          location.reload();

                        }

                      })

                      //fin sweet alert



                  

                }

            });

            //fin ajax

         

        }

      });

}





f











function agregarPedibles(datos) {

        id =  $(datos).attr("data-id");

        

        var data={

          tipo : "PLATO",

          idProducto : id

        }



        $.ajax({

        url: contextPath + "/agregarPedido?",

        method: "post",

        data: data,

        success: function() {

            Swal.fire("¡Disponible para pedir!", "La mesa ya puedregar pedido", "success");

        },

        error: function(xhr) {

            Swal.fire("Error", "No se pudo reservar la mesa.", "error");

        }

    });





}



$(document).ready(function () {

  

  //agregar listado por ajax















});