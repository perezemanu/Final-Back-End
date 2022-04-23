package com.example.integrador.repository.entity;

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
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Long dni;
    @Column
    private String email;
    @Column
    private LocalDate fechaIngreso;


    @OneToOne() // NO SE BORRA XQUE OTROS PACIENTES PUEDEN TENER LA MISMA DIRE, //cuidado con el lazy aca
    @JoinColumn(name = "id_domicilio",referencedColumnName = "id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos=new HashSet<>();

    public Paciente() {
    }
}
