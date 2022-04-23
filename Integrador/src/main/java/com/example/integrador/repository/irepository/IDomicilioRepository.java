package com.example.integrador.repository.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.integrador.repository.entity.Domicilio;
@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {
}
