window.addEventListener('load', function () {

  (function(){

    //con fetch invocamos a la API de s con el método GET
    //nos devolverá un JSON con una colección de s
    const url = 'http://localhost:8080/pacientes';
    const settings = {
      method: 'GET'
    }

    fetch(url,settings)
    .then(response => response.json())
    .then(data => {

      console.log(data);
    //recorremos la colección de s del JSON
       for(pacientes of data){
          //por cada pacientes armaremos una fila de la tabla
          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pacientes
          var table = document.getElementById("pacienteTable");
          var pacienteRow =table.insertRow();
          let tr_id = 'tr_' + pacientes.id;
          pacienteRow.id = tr_id;

          //por cada pacientes creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar una pacientes
          let deleteButton = '<button' +
                                    ' id=' + '\"' + 'btn_delete_' + pacientes.id + '\"' +
                                    ' type="button" onclick="deleteBy('+pacientes.id+')" class="btn btn-danger btn_delete">' +
                                    '&times' +
                                    '</button>';

          //por cada pacientes creamos un boton que muestra el id y que al hacerle clic invocará
          //a la función de java script findBy que se encargará de buscar la pacientes que queremos
          //modificar y mostrar los datos de la misma en un formulario.
          let updateButton = '<button' +
                                    ' id=' + '\"' + 'btn_id_' + pacientes.id + '\"' +
                                    ' type="button" onclick="findBy('+pacientes.id+')" class="btn btn-info btn_id">' +
                                    pacientes.id +
                                    '</button>';

          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del pacientes
          //como ultima columna el boton eliminar
          pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +
                  '<td class=\"td_titulo\">' + pacientes.nombre.toUpperCase() + '</td>' +
                  '<td class=\"td_categoria\">' + pacientes.apellido.toUpperCase() + '</td>' +
                  '<td class=\"td_categoria\">' + pacientes.dni + '</td>' +
                  '<td class=\"td_categoria\">' + pacientes.email+ '</td>' +
                  '<td>' + deleteButton + '</td>';

      };

  })
  })

  (function(){
    let pathname = window.location.pathname;
    if (pathname == "/listarPacientes.html.html") {
        document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })


  })