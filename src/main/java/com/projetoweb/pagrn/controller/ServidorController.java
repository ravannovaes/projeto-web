package com.projetoweb.pagrn.controller;

import com.projetoweb.pagrn.model.Servidor;
import com.projetoweb.pagrn.service.ServidorService;
import dto.ServidorDtoRequest;
import dto.ServidorDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/servidor")
public class ServidorController {
	
	   @Autowired
	    private ServidorService service;

	    @GetMapping
		public ResponseEntity<Page<ServidorDtoResponse>>listAll(@PageableDefault(size = 10) Pageable pageable){
			Page<Servidor> list = service.listAll(pageable);

			Page<ServidorDtoResponse> listDTO = list.map(obj -> new ServidorDtoResponse(obj));

			return ResponseEntity.ok(listDTO);
		}

	    @GetMapping(path = {"/{id}"})
	    public ResponseEntity<ServidorDtoResponse> getOne(@PathVariable Long id){
	        Optional<Servidor> cliente = service.findById(id);

	        if (cliente.isEmpty()){
	            return ResponseEntity.notFound().build();
	        }else{
	            ServidorDtoResponse servidorDtoResponse = new ServidorDtoResponse(cliente.get());
	            return ResponseEntity.ok().body(servidorDtoResponse);
	        }
	    }

	    
	    @PostMapping
	    public ResponseEntity<Servidor> insert(@RequestBody ServidorDtoRequest c){
	        if(c.getNomeSocial () == null ){
	            return ResponseEntity.status(400).body(c.convertToservidor());
	        }
	        Servidor ServidorDTO = service.insert(c.convertToservidor());
	        return ResponseEntity.status(201).body(ServidorDTO);
	    }
	    
	    /*
	    @PostMapping
	    public Servidor insert(@RequestBody ServidorDtoRequest c){
	    	   return service.insert( c.convertToservidor());
	    }
	    */
	        
	    /*	
	    	if(c.getMatricula() == null ){
	            return ResponseEntity.status(400).body(c);
	        }
	        Servidor Servidor = service.insert(c);
	        return ResponseEntity.status(201).body(Servidor);
	    }
	    */

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
