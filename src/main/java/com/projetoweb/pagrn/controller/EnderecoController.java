package com.projetoweb.pagrn.controller;

import java.util.List;
import java.util.Optional;

import com.projetoweb.pagrn.model.Endereco;
import com.projetoweb.pagrn.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> listALl(){

        //return service.listAll();
        List<Endereco> enderecoList = service.listAll();
        if(enderecoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            for(Endereco d : enderecoList){
                long id = d.getId();
                d.add(linkTo(methodOn(EnderecoController.class).getOne(id)).withSelfRel());
            }
            return new ResponseEntity<List<Endereco>>(enderecoList,HttpStatus.OK);
        }
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Endereco> getOne(@PathVariable Long id){
        Optional<Endereco> endereco = service.findById(id);

        if (endereco.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            //return ResponseEntity.notFound().build();
        }else{
            endereco.get().add(linkTo(methodOn(EnderecoController.class).listALl()).withRel("Lista de endereços"));
            return new ResponseEntity<Endereco>(endereco.get(),HttpStatus.OK);
            //return ResponseEntity.ok(cliente.get());
        }
    }

    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco c){
        if(c.getCep() == null ){
            return ResponseEntity.status(400).body(c);
        }
        Endereco endereco = service.insert(c);
        return ResponseEntity.status(201).body(endereco);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco c){
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

