package com.example.integrador.service;

import com.example.integrador.model.DomicilioDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.integrador.repository.entity.Domicilio;
import com.example.integrador.repository.irepository.IDomicilioRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    public void setDomicilioRepository(IDomicilioRepository domicilioRepository){
        this.domicilioRepository = domicilioRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public Set<DomicilioDTO> buscarTodos(){
        List<Domicilio> listaDomicilio = domicilioRepository.findAll();
        Set<DomicilioDTO> listaDomicilioDTO = new HashSet<>();

        for (Domicilio domicilio : listaDomicilio) {
            listaDomicilioDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }

        return listaDomicilioDTO;
    }
    public Domicilio guardar(Domicilio domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        return domicilioRepository.save(domicilio);
    }
    public DomicilioDTO buscarPorId(Long id){
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if (domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        }

        return domicilioDTO;
    }
    public void eliminar(Long id){
        domicilioRepository.deleteById(id);
    }
    public Domicilio actualizar(Domicilio domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        return domicilioDTO;
    }
}
