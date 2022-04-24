package com.example.integrador.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.example.integrador.repository.entity.Odontologo;
import com.example.integrador.repository.entity.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class TurnoDTO {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDateTime fecha;

    public TurnoDTO(Paciente paciente, Odontologo odontologo, LocalDateTime fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public TurnoDTO() {
    }
}

