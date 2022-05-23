package com.projetoweb.pagrn.repository;

import com.projetoweb.pagrn.model.Vinculo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VinculoRepository extends PagingAndSortingRepository<Vinculo,Long> {
    Page<Vinculo> findAll();
    Vinculo saveAndFlush(Vinculo entity);
}