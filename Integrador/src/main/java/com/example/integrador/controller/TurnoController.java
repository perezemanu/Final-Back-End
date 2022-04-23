package com.example.integrador.controller;

import com.example.integrador.model.OdontologoDTO;
import com.example.integrador.model.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.integrador.repository.entity.Odontologo;
import com.example.integrador.repository.entity.Turno;
import com.example.integrador.service.OdontologoService;
import com.example.integrador.service.PacienteService;
import com.example.integrador.service.TurnoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public List<Turno> listarTurnos(){
        return turnoService.buscarTodos();
    }
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) throws Exception {
        ResponseEntity<Turno> respuesta;
        //preguntar si es un paciente correcto y un odontologo correcto
        PacienteDTO pacienteBus=pacienteService.buscarPorId(turno.getId());
        OdontologoDTO  odontologoBus=odontologoService.buscarOdontologoPorId(turno.getId());

        if (pacienteBus!=null && odontologoBus!=null){
            respuesta= ResponseEntity.ok(turnoService.registrarTurno(turno));
        }
        else{
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        ResponseEntity<String> response;
        //controlar el id
        if (turnoService.buscarPorId(id)!=null){
            //existe
            turnoService.eliminar(id);
            response= ResponseEntity.status(HttpStatus.OK).body("Turno con id="+id+" eliminado");
        }
        else{
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro un turno con el id="+id);
        }
        return response;
    }
}
