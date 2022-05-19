package com.projetoweb.pagrn.service;



import java.util.List;
import java.util.Optional;

import com.projetoweb.pagrn.model.Deficiencia;
import com.projetoweb.pagrn.repository.DeficienciaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeficienciaService {
    Logger logger = LoggerFactory.getLogger(DeficienciaService.class);

    @Autowired
    DeficienciaRepository repository;


    public Deficiencia insert(Deficiencia c){
        logger.info("Deficiencia salva no sistema com sucesso");
        return repository.save(c);
    }

    public Deficiencia update(Deficiencia c){
        logger.info("Deficiencia alterada no sistema com sucesso");
        return repository.save(c);
    }

    public void delete (Deficiencia c){
        logger.info("Deficiencia deletada no sistema com sucesso");
        repository.delete(c);
    }

    public Deficiencia saveAndFlush(Deficiencia c){
        logger.info("Deficiencia salva no sistema com sucesso");
        return repository.saveAndFlush(c);
    }

    public Optional<Deficiencia> findById(Long id){
        return repository.findById(id);
    }

    public List<Deficiencia> listAll(){
        return repository.findAll();
    }

    public List<Deficiencia> paginatedList(Long page){
        return repository.findPaginatedDeficiency(page);
    }
}



