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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_paciente",nullable = false)
    private Paciente paciente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_odontologo",nullable = false)
    private Odontologo odontologo;


    @Column
    private LocalDateTime fecha;

    public Turno() {

    }

}
