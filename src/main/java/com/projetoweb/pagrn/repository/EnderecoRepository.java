package com.projetoweb.pagrn.repository;

import com.projetoweb.pagrn.model.Endereco;
import com.projetoweb.pagrn.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnderecoRepository extends PagingAndSortingRepository<Endereco,Long> {
    Page<Endereco> findAll();
    Endereco saveAndFlush(Endereco entity);
}
