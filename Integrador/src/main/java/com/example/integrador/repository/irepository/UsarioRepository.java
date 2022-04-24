package com.example.integrador.repository.irepository;


import com.example.integrador.repository.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UsarioRepository extends JpaRepository<Usuario, Integer> {

    //agregue el query a ver si funciona postman 20/04
    @Query
    Optional<Usuario> findByUsername(String username);
}
