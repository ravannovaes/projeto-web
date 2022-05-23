package com.projetoweb.pagrn.controller;

import com.projetoweb.pagrn.model.Vinculo;
import com.projetoweb.pagrn.service.VinculoService;
import dto.VinculoDtoResquest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vinculo")
public class VinculoController {
	
	   @Autowired
	    private VinculoService service;

	    @GetMapping
	    public List<Vinculo> listALl(@RequestParam(required = false,defaultValue="0") Boolean asc,
									 @RequestParam(required = false,defaultValue="id") String col,
									 @RequestParam(required = false,defaultValue="0") int page){
			return service.listAll(asc,col,page);
	    }

	    @GetMapping(path = {"/{id}"})
	    public ResponseEntity<Vinculo> getOne(@PathVariable Long id){
	        Optional<Vinculo> cliente = service.findById(id);

	        if (cliente.isEmpty()){
	            return ResponseEntity.notFound().build();
	        }else{
	            return ResponseEntity.ok(cliente.get());
	        }
	    }

	    
	    @PostMapping
	    public ResponseEntity<Vinculo> insert(@RequestBody VinculoDtoResquest c){
	        if(c.getData_exercicio() == null ){
	        	
	            return ResponseEntity.status(400).body(c.convertToVinculo());
	        }
	        Vinculo DTO = service.insert(c.convertToVinculo());
	        return ResponseEntity.status(201).body(DTO);
	    }
	    

	    @PutMapping(path = {"/{id}"})
	    public ResponseEntity<Vinculo> update(@PathVariable Long id, @RequestBody Vinculo c){
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
