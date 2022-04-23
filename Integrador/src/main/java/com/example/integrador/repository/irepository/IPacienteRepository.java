package com.example.integrador.repository.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.integrador.repository.entity.Paciente;

import java.util.Optional;
@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
    //@Query("select p from Paciente p where p.id = :id_domicilio")
    //Optional<Paciente> findByDni(String dni);
    //Optional<Paciente> getPatientById(@Param("id_adress")Long id_adress);
}
