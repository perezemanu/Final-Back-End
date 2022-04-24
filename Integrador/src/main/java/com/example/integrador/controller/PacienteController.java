package com.example.integrador.controller;

import com.example.integrador.excepcions.NotFoundException;
import com.example.integrador.model.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.integrador.repository.entity.Paciente;
import com.example.integrador.service.PacienteService;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*")

public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable Long id) throws Exception {
        return pacienteService.buscarPorId(id);
    }

    @GetMapping
    public Set<PacienteDTO> buscarPacientes() throws NotFoundException {
        return pacienteService.buscarTodos();
    }

    @PostMapping
    public PacienteDTO registrarPaciente(@RequestBody PacienteDTO paciente) throws NotFoundException{
        return pacienteService.guardar(paciente);
    }
    @PutMapping
    public PacienteDTO actualizarPaciente(@RequestBody PacienteDTO paciente) throws NotFoundException {
        return pacienteService.actualizar(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        ResponseEntity<String> response=null;
        if(pacienteService.buscarPorId(id)!=null){
            pacienteService.eliminar(id);
            response=ResponseEntity.ok("Paciente eliminado");
        }
        else{
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        }
        return response;
    }
}
