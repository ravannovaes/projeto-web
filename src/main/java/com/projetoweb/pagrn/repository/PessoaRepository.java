package com.projetoweb.pagrn.repository;

import com.projetoweb.pagrn.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface PessoaRepository extends PagingAndSortingRepository<Pessoa,Long> {
    Page<Pessoa> findAll();
    Pessoa saveAndFlush(Pessoa entity);
}
