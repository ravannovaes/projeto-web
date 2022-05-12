package com.projetoweb.pagrn.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.repository.PessoaRepository;


	@Service
	public class PessoaService {
		
		@Autowired
		PessoaRepository repository;
		
	    
	    public Pessoa insert(Pessoa c){
	        return repository.save(c);
	    }

	    public Pessoa update(Pessoa c){
	        return repository.save(c);
	    }

	    public void delete (Pessoa c){
	        repository.delete(c);
	    }

	    public Pessoa saveAndFlush(Pessoa c){
	        return repository.saveAndFlush(c);
	    }

	    public Optional<Pessoa> findById(Long id){
	        return repository.findById(id);
	    }

	    public List<Pessoa> listAll(){
	        return repository.findAll();
	    }
	    
	    
	}



