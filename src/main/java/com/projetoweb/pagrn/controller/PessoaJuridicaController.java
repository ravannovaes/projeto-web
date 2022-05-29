package com.projetoweb.pagrn.controller;

import com.projetoweb.pagrn.model.PessoaJuridica;

import com.projetoweb.pagrn.service.PessoaJuridicaService;
import dto.PessoaJuridicaDtoRequest;
import dto.PessoaJuridicaDtoResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController {
	
	@Autowired
	private PessoaJuridicaService service;

	@GetMapping
	public List<PessoaJuridica> listALl(@RequestParam(required = false,defaultValue="0") Boolean asc,
										@RequestParam(required = false,defaultValue="id") String col,
										@RequestParam(required = false,defaultValue="0") int page){
		return service.listAll(asc,col,page);
	}

	
	/*
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<PessoaJuridica> getOne(@PathVariable Long id){
		Optional<PessoaJuridica> cliente = service.findById(id);

		if (cliente.isEmpty()){
			return ResponseEntity.notFound().build();
		}else{
			return ResponseEntity.ok(cliente.get());
		}
	}
	*/
	
	
	
	 @GetMapping(path = {"/{id}"})
	    public ResponseEntity<PessoaJuridicaDtoResponse> getOne(@PathVariable Long id){
	        Optional<PessoaJuridica> cliente = service.findById(id);

	        if (cliente.isEmpty()){
	            return ResponseEntity.notFound().build();
	        }else{
	            PessoaJuridicaDtoResponse PessoaJuridicaDtoResponse = new PessoaJuridicaDtoResponse(cliente.get());
	            return ResponseEntity.ok().body(PessoaJuridicaDtoResponse);
	        }
	    }
	    
	
 
	@PostMapping
	 public ResponseEntity<PessoaJuridica> insert(@RequestBody PessoaJuridicaDtoRequest c){
		
	  
	        PessoaJuridica DTO = service.insert(c.convertToPessoaJuridica());
	        return ResponseEntity.status(201).body(DTO);
	    }
	
	 
	/*
	public ResponseEntity<PessoaJuridica> insert(@RequestBody PessoaJuridica c){
		if(c.getCnpj() == null ){
			return ResponseEntity.status(400).body(c);
		}
		PessoaJuridica	PessoaJuridica = service.insert(c);
		return ResponseEntity.status(201).body(PessoaJuridica);
	}
	*/

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<PessoaJuridica> update(@PathVariable Long id, @RequestBody PessoaJuridica c){
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
