package com.example.integrador.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;
    @JsonIgnore
    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    private Set<Turno> turnos=new HashSet<>();

    public Odontologo() {
    }
}
