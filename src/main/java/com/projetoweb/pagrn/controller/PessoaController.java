package com.projetoweb.pagrn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.service.PessoaService;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping
	public List<Pessoa> listALl(){
		return service.listAll();
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Pessoa> getOne(@PathVariable Long id){
		Optional<Pessoa> cliente = service.findById(id);

		if (cliente.isEmpty()){
			return ResponseEntity.notFound().build();
		}else{
			return ResponseEntity.ok(cliente.get());
		}
	}

	@PostMapping
	public ResponseEntity<Pessoa> insert(@RequestBody Pessoa c){
		if(c.getCpf() == null || c.getDataNasc()== null || c.getTelefone()== null ||
				c.getNome()== null || c.getNomeMae()== null || c.getSexo()== null ||
				c.getEstadoCivil()== null){
			return ResponseEntity.status(400).body(c);
		}
		Pessoa	pessoa = service.insert(c);
		return ResponseEntity.status(201).body(pessoa);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa c){
		return service.findById(id)
				.map( record -> {
					service.saveAndFlush(c);
					return ResponseEntity.ok(c);
				}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return service.findById(id)
				.map( record -> {
					service.delete(record);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}

}
	
