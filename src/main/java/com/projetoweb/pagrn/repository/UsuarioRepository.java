package com.projetoweb.pagrn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoweb.pagrn.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	 Optional<Usuario> findUsuarioByUsername(String username);

}
