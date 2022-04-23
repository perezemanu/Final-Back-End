package com.example.integrador.service;

import com.example.integrador.model.PacienteDTO;
import com.example.integrador.repository.entity.Domicilio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.integrador.repository.entity.Paciente;
import com.example.integrador.repository.irepository.IPacienteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService {

    private IPacienteRepository pacienteRepository;

    final static Logger logger = LogManager.getLogger(PacienteService.class);

    @Autowired
    public void setPacienteRepository(IPacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @Autowired
    ObjectMapper mapper;


    public Set<PacienteDTO> buscarTodos(){
        List<Paciente> listaPacientes=pacienteRepository.findAll();
        Set<PacienteDTO> pacienteListaDTO=new HashSet<>();
        for (Paciente paciente:listaPacientes) {
            pacienteListaDTO.add(mapper.convertValue(paciente,PacienteDTO.class));

        }
        return pacienteListaDTO;
    }

    public PacienteDTO guardar(PacienteDTO pacienteDTO){
        Paciente paciente= mapper.convertValue(pacienteDTO,Paciente.class);
        Paciente pacienteGuardado=pacienteRepository.save(paciente);
        return mapper.convertValue(pacienteGuardado,PacienteDTO.class);
    }
//    public Paciente guardar(Paciente paciente){
//        return pacienteRepository.save(paciente);
//    }

    public PacienteDTO buscarPorId(Long id) throws Exception {
        Optional<Paciente> pacienteEncontrado= pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if (pacienteEncontrado.isPresent()){
            pacienteDTO = mapper.convertValue(pacienteEncontrado,PacienteDTO.class);
        }


        return pacienteDTO;

    }

    public void eliminar(Long id){
        pacienteRepository.deleteById(id);
    }

    public PacienteDTO actualizar(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);
        return pacienteDTO;
    }
}
