window.addEventListener('load', function () {


    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado de la pelicula
    const formulario = document.querySelector('#update_odontologo_form');

    formulario.addEventListener('submit', function (event) {
     
        let odontologoId = document.querySelector('#odontologoId').value;

        //creamos un JSON que tendrá los datos de la película
        //a diferencia de una pelicula nueva en este caso enviamos el id
        //para poder identificarla y modificarla para no cargarla como nueva
        const formData = {
            id: document.querySelector('#odontologoId').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,
           
            
        };

        //invocamos utilizando la función fetch la API peliculas con el método PUT que modificará
        //la película que enviaremos en formato JSON
        const url = 'http://localhost:8080/odontologos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de una pelicula del listado
    //se encarga de llenar el formulario con los datos de la pelicula
    //que se desea modificar
    function findBy(id) {
          const url = 'http://localhost:8080/odontologos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let odontologos = data;
              document.querySelector('#odontologoId').value = odontologos.id;
              document.querySelector('#nombre').value = odontologos.nombre;
              document.querySelector('#apellido').value = odontologos.apellido;
              document.querySelector('#matricula').value = odontologos.matricula;
              
              //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_odontologo_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }