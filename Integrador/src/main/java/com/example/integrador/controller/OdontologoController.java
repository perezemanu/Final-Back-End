package com.example.integrador.controller;


import com.example.integrador.excepcions.NotFoundException;
import com.example.integrador.model.OdontologoDTO;
import com.example.integrador.model.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.integrador.repository.entity.Odontologo;
import com.example.integrador.service.OdontologoService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin(origins = "*")
public class OdontologoController {

        private OdontologoService odontologoService;

        @Autowired
        public void setOdontologoService (OdontologoService odontologoService){
            this.odontologoService = odontologoService;
        }

        @PostMapping()
        public OdontologoDTO registrarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
            return odontologoService.guardarOdontologo(odontologoDTO);

        }

        @GetMapping("/{id}")
        public ResponseEntity<OdontologoDTO> findById(@PathVariable Long id) throws Exception {

            ResponseEntity<OdontologoDTO> response = null;
            if (odontologoService.buscarOdontologoPorId(id)!=null) {
                response = ResponseEntity.ok(odontologoService.buscarOdontologoPorId(id));
            } else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return response;

        }

//        @PutMapping()
//        public ResponseEntity<OdontologoDTO> update(@RequestBody OdontologoDTO odontologo) throws Exception {
//            ResponseEntity<OdontologoDTO> response = null;
//
//            if (odontologo.getId() != null && odontologoService.buscarOdontologoPorId(odontologo.getId()) != null)
//                response = ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
//            else
//                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//            return response;
//        }

    @PutMapping()
    public ResponseEntity<OdontologoDTO> update(@RequestBody OdontologoDTO odontologoDTO) throws Exception {
        ResponseEntity<OdontologoDTO> response = null;

        if (odontologoDTO.getId() != null && odontologoService.buscarOdontologoPorId(odontologoDTO.getId()) != null)
            response = ResponseEntity.ok(odontologoService.actualizar(odontologoDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }


        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
            ResponseEntity<String> response = null;

            if (odontologoService.buscarOdontologoPorId(id) != null) {
                odontologoService.borrarOdontologo(id);
                response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
            } else {
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return response;
        }

        @GetMapping
        public ResponseEntity<Set<OdontologoDTO>> findAll(){
           if(odontologoService.buscarTodos()!=null){
               return ResponseEntity.ok(odontologoService.buscarTodos());
           }else {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }


        }
        @GetMapping("/{id}")
        public ResponseEntity<OdontologoDTO> buscarPorId(@RequestParam Long id) throws NotFoundException {

            if(odontologoService.buscarOdontologoPorId(id)!=null){
                //encontro algo?
                 return ResponseEntity.ok(odontologoService.buscarOdontologoPorId(id));

            }else{
                //no encontró?
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            }



        }

    }

