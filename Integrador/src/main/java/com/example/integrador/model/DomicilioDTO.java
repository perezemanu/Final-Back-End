package com.example.integrador.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DomicilioDTO {
    private int id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    public DomicilioDTO(int id, String calle, int numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public DomicilioDTO(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
