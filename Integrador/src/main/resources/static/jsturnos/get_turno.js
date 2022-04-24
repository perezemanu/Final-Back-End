window.addEventListener('load', function () {

  (function(){

    //con fetch invocamos a la API de s con el método GET
    //nos devolverá un JSON con una colección de s
    const url = 'http://localhost:8080/turnos';
    const settings = {
      method: 'GET'
    }

    fetch(url,settings)
    .then(response => response.json())
    .then(data => {

      console.log(data);
    //recorremos la colección de s del JSON
       for(turnos of data){
          //por cada pacientes armaremos una fila de la tabla
          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pacientes
          var table = document.getElementById("turnosTable");
          var turnosRow =table.insertRow();
          let tr_id = 'tr_' + turnos.id;
          turnosRow.id = tr_id;

          //por cada turnos creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar una turnos
          let deleteButton = '<button' +
                                    ' id=' + '\"' + 'btn_delete_' + turnos.id + '\"' +
                                    ' type="button" onclick="deleteBy('+turnos.id+')" class="btn btn-danger btn_delete">' +
                                    '&times' +
                                    '</button>';

          //por cada turnos creamos un boton que muestra el id y que al hacerle clic invocará
          //a la función de java script findBy que se encargará de buscar la turnos que queremos
          //modificar y mostrar los datos de la misma en un formulario.
          let updateButton = '<button' +
                                    ' id=' + '\"' + 'btn_id_' + turnos.id + '\"' +
                                    ' type="button" onclick="findBy('+turnos.id+')" class="btn btn-info btn_id">' +
                                    turnos.id +
                                    '</button>';

          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del turnos
          //como ultima columna el boton eliminar
          turnosRow.innerHTML = '<td>' + updateButton + '</td>' +
                  '<td class=\"td_titulo\">' + turnos.paciente.nombre.toUpperCase() + '</td>' +
                  '<td class=\"td_categoria\">' + turnos.paciente.apellido.toUpperCase() + '</td>' +
                  '<td class=\"td_categoria\">' + turnos.paciente.dni + '</td>' +
                  '<td class=\"td_categoria\">' + turnos.paciente.email+ '</td>' +
                  '<td class=\"td_categoria\">' + turnos.odontologo.nombre+ '</td>' +
                  '<td class=\"td_categoria\">' + turnos.odontologo.apellido +  '</td>' +
                  '<td class=\"td_categoria\">' + turnos.odontologo.matricula +  '</td>' +
                  '<td class=\"td_categoria\">' + turnos.fecha  + '</td>'  +
                  
                  '<td>' + deleteButton + '</td>';

      };

  })
  })

  (function(){
    let pathname = window.location.pathname;
    if (pathname == "/listarTurnos.html") {
        document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })


  })