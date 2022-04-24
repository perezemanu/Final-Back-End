package com.example.integrador.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private String email;
    private LocalDate fechaIngreso;
    @OneToOne(cascade = CascadeType.ALL) // NO SE BORRA XQUE OTROS PACIENTES PUEDEN TENER LA MISMA DIRE, //cuidado con el lazy aca
    @JoinColumn(name = "id_domicilio",referencedColumnName = "id")
    private Domicilio domicilio;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL)
    private Set<Turno> turnos=new HashSet<>();

    public Paciente() {
    }
}
