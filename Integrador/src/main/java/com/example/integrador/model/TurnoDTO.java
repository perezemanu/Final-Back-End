package com.example.integrador.model;

import lombok.Getter;
import lombok.Setter;
import com.example.integrador.repository.entity.Odontologo;
import com.example.integrador.repository.entity.Paciente;

import java.time.LocalDate;
@Setter
@Getter
public class TurnoDTO {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;

    public TurnoDTO(Long id, Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }
}
