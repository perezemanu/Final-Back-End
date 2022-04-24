package com.example.integrador.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name="turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_paciente",nullable = false)
    private Paciente paciente;


    @ManyToOne
    @JoinColumn(name ="id_odontologo",nullable = false)
    private Odontologo odontologo;

    private LocalDateTime fecha;



    public Turno() {

    }


}
