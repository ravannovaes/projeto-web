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

import com.projetoweb.pagrn.model.Endereco;
import com.projetoweb.pagrn.repository.EnderecoRepository;


@Service
public class EnderecoService {
    Logger logger = LoggerFactory.getLogger(EnderecoService.class);

    @Autowired
    EnderecoRepository repository;


    public Endereco insert(Endereco c){
        logger.info("Endereço salvo no sistema com sucesso");
        return repository.save(c);
    }

    public Endereco update(Endereco c){
        logger.info("Endereço salvo no sistema com sucesso");
        return repository.save(c);
    }

    public void delete (Endereco c){
        logger.info("Endereço salvo no sistema com sucesso");
        repository.delete(c);
    }

    public Endereco saveAndFlush(Endereco c){
        logger.info("Endereço salvo no sistema com sucesso");
        return repository.saveAndFlush(c);
    }

    public Optional<Endereco> findById(Long id){
        return repository.findById(id);
    }

    public List<Endereco> listAll(Boolean asc, String col, int page){
        Pageable pageSearch;

        pageSearch = asc == Boolean.FALSE ?
                PageRequest.of(page, 5, Sort.by(col).descending()) :
                PageRequest.of(page, 5, Sort.by(col).ascending());

        List<Endereco> result = repository.findAll(pageSearch).getContent();
        return result;
    }


}



