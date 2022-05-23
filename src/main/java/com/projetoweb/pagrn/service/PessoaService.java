package com.projetoweb.pagrn.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.repository.PessoaRepository;


@Service
public class PessoaService {
    Logger logger = LoggerFactory.getLogger(PessoaService.class);

    @Autowired
    PessoaRepository repository;


    public Pessoa insert(Pessoa c){
        logger.info("Pessoa salva no sistema com sucesso");
        return repository.save(c);
    }

    public Pessoa update(Pessoa c){
        logger.info("Pessoa alterada no sistema com sucesso");
        return repository.save(c);
    }

    public void delete (Pessoa c){
        logger.info("Pessoa deletada no sistema com sucesso");
        repository.delete(c);
    }

    public Pessoa saveAndFlush(Pessoa c){
        logger.info("Pessoa salva no sistema com sucesso");
        return repository.saveAndFlush(c);
    }

    public Optional<Pessoa> findById(Long id){
        return repository.findById(id);
    }

    public List<Pessoa> listAll(Boolean asc,String col,int page){
        Pageable pageSearch;

        pageSearch = asc == Boolean.FALSE ?
                PageRequest.of(page, 5, Sort.by(col).descending()) :
                PageRequest.of(page, 5, Sort.by(col).ascending());

        List<Pessoa> result = repository.findAll(pageSearch).getContent();
        return result;
    }


}



