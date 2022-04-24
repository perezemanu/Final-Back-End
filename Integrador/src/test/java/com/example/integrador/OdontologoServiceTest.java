package com.example.integrador;


import com.example.integrador.excepcions.NotFoundException;
import com.example.integrador.model.DomicilioDTO;
import com.example.integrador.model.OdontologoDTO;
import com.example.integrador.model.PacienteDTO;
import com.example.integrador.repository.entity.Domicilio;
import com.example.integrador.service.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OdontologoServiceTest {

    private OdontologoService odontologoService;
    @Autowired
    public void setOdontologoService(OdontologoService odontologoService){
        this.odontologoService = odontologoService;
    }

    @Autowired
    ObjectMapper mapper;


    @Test
    void crearYBuscarTodosLosOdontologos(){
        OdontologoDTO odontologoDTO = new OdontologoDTO("Batman", "Rick",324324);
        odontologoService.guardarOdontologo(odontologoDTO);

        OdontologoDTO odontologoDTO1 = new OdontologoDTO("Superman", "Clark",32444324);
        odontologoService.guardarOdontologo(odontologoDTO1);

        OdontologoDTO odontologoDTO2 = new OdontologoDTO("Spiderman", "Peter",32444324);
        odontologoService.guardarOdontologo(odontologoDTO2);


        Assertions.assertNotNull(odontologoService.buscarTodos());

    }

    @Test
    void eliminarOdontologo() throws NotFoundException {
        OdontologoDTO odontologoDTO = new OdontologoDTO("Batman", "Rick",324324);
        OdontologoDTO odontologoDTOcreado = odontologoService.guardarOdontologo(odontologoDTO);

        OdontologoDTO odontologoDTO1 = new OdontologoDTO("Superman", "Clark",32444324);
        OdontologoDTO odontologoDTO2creado = odontologoService.guardarOdontologo(odontologoDTO1);

        odontologoService.borrarOdontologo(odontologoDTO2creado.getId());

        Assertions.assertThrows(NotFoundException.class, ()-> {
            odontologoService.buscarOdontologoPorId(odontologoDTO2creado.getId());});
    }

}
