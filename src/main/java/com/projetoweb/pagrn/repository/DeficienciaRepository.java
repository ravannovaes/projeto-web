package com.projetoweb.pagrn.repository;

import com.projetoweb.pagrn.model.Deficiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DeficienciaRepository extends JpaRepository<Deficiencia,Long> {

    @Query(value="SELECT * FROM Deficiencia limit 15 offset ?1 * 15",nativeQuery = true)
    List<Deficiencia> findPaginatedDeficiency(Long page);
}
