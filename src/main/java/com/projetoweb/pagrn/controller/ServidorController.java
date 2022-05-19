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

import com.projetoweb.pagrn.model.Servidor;
import com.projetoweb.pagrn.service.ServidorService;


@RestController
@RequestMapping("/servidor")
public class ServidorController {
	
	   @Autowired
	    private ServidorService service;

	    @GetMapping
	    public List<Servidor> listALl(){
	        return service.listAll();
	    }

	    @GetMapping(path = {"/{id}"})
	    public ResponseEntity<Servidor> getOne(@PathVariable Long id){
	        Optional<Servidor> cliente = service.findById(id);

	        if (cliente.isEmpty()){
	            return ResponseEntity.notFound().build();
	        }else{
	            return ResponseEntity.ok(cliente.get());
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Servidor> insert(@RequestBody Servidor c){
	        if(c.getMatricula() == null ){
	            return ResponseEntity.status(400).body(c);
	        }
	        Servidor Servidor = service.insert(c);
	        return ResponseEntity.status(201).body(Servidor);
	    }

	    @PutMapping(path = {"/{id}"})
	    public ResponseEntity<Servidor> update(@PathVariable Long id, @RequestBody Servidor c){
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
