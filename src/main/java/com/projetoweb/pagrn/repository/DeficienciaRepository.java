package com.projetoweb.pagrn.repository;

import com.projetoweb.pagrn.model.Deficiencia;
import com.projetoweb.pagrn.model.Vinculo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DeficienciaRepository extends PagingAndSortingRepository<Deficiencia,Long> {

    @Query(value="SELECT * FROM Deficiencia limit 15 offset ?1 * 15",nativeQuery = true)
    List<Deficiencia> findPaginatedDeficiency(Long page);

    Page<Deficiencia> findAll();
    Deficiencia saveAndFlush(Deficiencia entity);
}
