package com.example.integrador.repository.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String calle;
    @Column
    private String numero;
    @Column
    private String provincia;

    @OneToOne(mappedBy = "domicilio")
    private Paciente paciente;

}
