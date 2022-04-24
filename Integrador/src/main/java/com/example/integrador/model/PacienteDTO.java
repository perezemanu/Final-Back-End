package com.example.integrador.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.example.integrador.repository.entity.Domicilio;

import java.time.LocalDate;
@Setter @Getter @AllArgsConstructor
public class PacienteDTO {
    private int id;
    private String apellido;
    private String nombre;
    private String email;
    private int dni;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;

    public PacienteDTO(String apellido, String nombre, String email, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public PacienteDTO() {
    }
}
