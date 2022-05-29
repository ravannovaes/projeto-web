package com.projetoweb.pagrn.repository;

import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.model.Servidor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServidorRepository extends PagingAndSortingRepository<Servidor,Long> {
    Page<Servidor> findAll();
    Servidor saveAndFlush(Servidor entity);
}
