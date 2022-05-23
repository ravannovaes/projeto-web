package com.projetoweb.pagrn.repository;

import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.model.PessoaJuridica;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PessoaJuridicaRepository extends PagingAndSortingRepository<PessoaJuridica,Long > {
    Page<PessoaJuridica> findAll();
    PessoaJuridica saveAndFlush(PessoaJuridica entity);
}
