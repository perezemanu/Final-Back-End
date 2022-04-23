package com.example.integrador.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="odontologo")
@Entity
@Getter @Setter

public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "odontologo_seq")
    @SequenceGenerator(name = "odontologo_seq", sequenceName = "odontologo_seq", allocationSize = 1)
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="matricula")
    private Integer matricula;
    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    private Set<Turno> turnos=new HashSet<>();

    public Odontologo() {
    }
}
