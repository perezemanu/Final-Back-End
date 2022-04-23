package com.example.integrador.repository.irepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.integrador.repository.entity.Odontologo;

import java.util.List;
import java.util.Optional;
@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {
    //Optional<List<Odontologo>> findByLicense(String license);
}
