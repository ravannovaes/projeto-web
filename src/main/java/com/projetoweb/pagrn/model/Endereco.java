package com.projetoweb.pagrn.model;


import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Endereco")
public class Endereco extends RepresentationModel<Endereco> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String latitude;
    private String longitude;
    private String numero;
    private String complemento;
    private String logradouro;
    private String cep;

    public Endereco(String latitude, String longitude, String numero, String complemento, String logradouro, String cep) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.numero = numero;
        this.complemento = complemento;
        this.logradouro = logradouro;
        this.cep = cep;
    }

    public Endereco(){}

    public Endereco(String cep) {
        this.cep = cep;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
