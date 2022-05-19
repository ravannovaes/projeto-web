package com.projetoweb.pagrn.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoweb.pagrn.model.Vinculo;
import com.projetoweb.pagrn.repository.VinculoRepository;

@Service
public class VinculoService {
	

    Logger logger = LoggerFactory.getLogger(VinculoService.class);

    @Autowired
    VinculoRepository repository;


    public Vinculo insert(Vinculo c){
        logger.info("Vinculo salvo no sistema com sucesso");
        return repository.save(c);
    }

    public Vinculo update(Vinculo c){
        logger.info("Vinculo alterada no sistema com sucesso");
        return repository.save(c);
    }

    public void delete (Vinculo c){
        logger.info("Vinculo deletado no sistema com sucesso");
        repository.delete(c);
    }

    public Vinculo saveAndFlush(Vinculo c){
        logger.info("Vinculo salvo no sistema com sucesso");
        return repository.saveAndFlush(c);
    }

    public Optional<Vinculo> findById(Long id){
        return repository.findById(id);
    }

    public List<Vinculo> listAll(){
        return repository.findAll();
    }

}
