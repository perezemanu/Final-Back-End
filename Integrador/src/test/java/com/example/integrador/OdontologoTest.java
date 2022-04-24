package com.example.integrador;

import com.example.integrador.model.OdontologoDTO;
import com.example.integrador.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;

@SpringBootTest
class OdontologoTest {

    private OdontologoService odontologoService;
    @Autowired
    public void setOdontologoService(OdontologoService odontologoService) throws ChangeSetPersister.NotFoundException {
        this.odontologoService = odontologoService;
    }

    @Test
    void crearYBuscarOdontologo() throws Exception {
        OdontologoDTO odontologoCreado = odontologoService.guardarOdontologo(new OdontologoDTO("Marcos","Burdiles",545));

        Assertions.assertTrue(odontologoService.buscarOdontologoPorId(odontologoCreado.getId()) != null);
    }

    @Test
    void actualizarOdontologo()  throws ChangeSetPersister.NotFoundException {
        OdontologoDTO odontologoCreado = odontologoService.guardarOdontologo(new OdontologoDTO("Milena","Sandoval",687684));

        odontologoCreado.setApellido("Sandoval");
        odontologoService.guardarOdontologo(odontologoCreado);

        Assertions.assertTrue(odontologoCreado.getApellido() == "Burdiles");
    }
}