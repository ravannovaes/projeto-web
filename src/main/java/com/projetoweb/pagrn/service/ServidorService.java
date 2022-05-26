package com.projetoweb.pagrn.service;


import java.util.List;
import java.util.Optional;

import com.projetoweb.pagrn.model.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projetoweb.pagrn.model.Servidor;
import com.projetoweb.pagrn.repository.ServidorRepository;


@Service
public class ServidorService {
	
	
	    Logger logger = LoggerFactory.getLogger(ServidorService.class);

	    @Autowired
	    ServidorRepository repository;

	    public Servidor insert(Servidor c){
	        logger.info("Servidor salvo no sistema com sucesso");
	        return repository.save(c);
	    }

	    public Servidor update(Servidor c){
	        logger.info("Servidor alterado no sistema com sucesso");
	        return repository.save(c);
	    }

	    public void delete (Servidor c){
	        logger.info("Servidor deletado no sistema com sucesso");
	        repository.delete(c);
	    }

	    public Servidor saveAndFlush(Servidor c){
	        logger.info("Servidor salvo no sistema com sucesso");
	        return repository.saveAndFlush(c);
	    }

	    public Optional<Servidor> findById(Long id){
	        return repository.findById(id);
	    }


		public Page<Servidor> listAll(Pageable pageable){
	    //public List<Servidor> listAll(Boolean asc, String col, int page){
			//Pageable pageSearch;

			//pageSearch = asc == Boolean.FALSE ?
			//		PageRequest.of(page, 5, Sort.by(col).descending()) :
			//		PageRequest.of(page, 5, Sort.by(col).ascending());

			//List<Servidor> result = repository.findAll(pageSearch).getContent();
			return repository.findAll(pageable);
			//return result;
	    }
}



