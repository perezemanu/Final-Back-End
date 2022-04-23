package com.example.integrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.integrador.repository.entity.Turno;
import com.example.integrador.repository.irepository.ITurnoRepository;

import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    public List<Turno> buscarTodos() {
        return turnoRepository.findAll();
    }

    public Turno buscarPorId(Long id) {
        return turnoRepository.findById(id).get();
    }

    public Turno registrarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }


}
