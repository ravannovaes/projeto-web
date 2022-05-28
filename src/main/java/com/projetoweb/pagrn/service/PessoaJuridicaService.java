package com.projetoweb.pagrn.service;

import java.util.List;
import java.util.Optional;

import com.projetoweb.pagrn.model.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projetoweb.pagrn.model.PessoaJuridica;
import com.projetoweb.pagrn.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService {
    Logger logger = LoggerFactory.getLogger(PessoaJuridicaService.class);

    @Autowired
    PessoaJuridicaRepository repository;


    public PessoaJuridica insert(PessoaJuridica c){
        logger.info("PessoaJuridica salva no sistema com sucesso");
        return repository.save(c);
    }

    public PessoaJuridica update(PessoaJuridica c){
        logger.info("PessoaJuridica alterada no sistema com sucesso");
        return repository.save(c);
    }

    public void delete (PessoaJuridica c){
        logger.info("PessoaJuridica deletada no sistema com sucesso");
        repository.delete(c);
    }

    public PessoaJuridica saveAndFlush(PessoaJuridica c){
        logger.info("PessoaJuridica salva no sistema com sucesso");
        return repository.saveAndFlush(c);
    }

    public Optional<PessoaJuridica> findById(Long id){
        return repository.findById(id);
    }

    public List<PessoaJuridica> listAll(Boolean asc, String col, int page){
        Pageable pageSearch;

        pageSearch = asc == Boolean.FALSE ?
                PageRequest.of(page, 5, Sort.by(col).descending()) :
                PageRequest.of(page, 5, Sort.by(col).ascending());

        List<PessoaJuridica> result = repository.findAll(pageSearch).getContent();
        return result;
    }

}
