package com.example.integrador.service;

import com.example.integrador.excepcions.NotFoundException;
import com.example.integrador.repository.irepository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.integrador.model.OdontologoDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.integrador.repository.entity.Odontologo;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class OdontologoService {


    //OdontologoDTO odontologoDTO;

    public OdontologoService() {
    }
    final static Logger logger = LogManager.getLogger(OdontologoService.class);
    IOdontologoRepository odontologoRepository;
    @Autowired
    public void setOdontologoRepository(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    private ObjectMapper objectMapper;
    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public OdontologoDTO guardarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = objectMapper.convertValue(odontologoDTO, Odontologo.class);
        Odontologo odontolgoGuardado = odontologoRepository.save(odontologo);
        return objectMapper.convertValue(odontolgoGuardado, OdontologoDTO.class);
    }

    public OdontologoDTO buscarOdontologoPorId(Long id) throws NotFoundException {
        Optional<Odontologo> odontologoEncontrado = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO=null;
        if (odontologoEncontrado.isPresent()) {
            odontologoDTO=objectMapper.convertValue(odontologoEncontrado.get(),OdontologoDTO.class);

        }else{
            throw new NotFoundException("No existe un odontólogo con el id:" + id);

        }
        return odontologoDTO;



    }
    public Set<OdontologoDTO> buscarTodos(){
        List<Odontologo> listaOdontologo=odontologoRepository.findAll();
        Set<OdontologoDTO> listaOdontologoDTO= new HashSet<>();
        for (Odontologo odontologo:listaOdontologo) {
            listaOdontologoDTO.add(objectMapper.convertValue(odontologo,OdontologoDTO.class));
        }
        return listaOdontologoDTO;
    }

    public void borrarOdontologo(Long id) throws NotFoundException {
        if(buscarOdontologoPorId(id)!=null){
            odontologoRepository.deleteById(id);
        }
    }
    public OdontologoDTO actualizar(OdontologoDTO odontologoDTO) {
        return guardarOdontologo(odontologoDTO);
    }

//    public Object guardarOdontologo(Odontologo odontologo) {
//        return odontologoRepository.save(odontologo);
//    }
};