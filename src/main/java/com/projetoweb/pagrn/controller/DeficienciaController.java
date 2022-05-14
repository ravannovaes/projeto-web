package com.projetoweb.pagrn.controller;

import java.util.List;
import java.util.Optional;

import com.projetoweb.pagrn.model.Deficiencia;
import com.projetoweb.pagrn.service.DeficienciaService;
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
@RequestMapping("/deficiencia")
public class DeficienciaController {

    @Autowired
    private DeficienciaService service;

    @GetMapping
    public List<Deficiencia> listALl(){
        return service.listAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Deficiencia> getOne(@PathVariable Long id){
        Optional<Deficiencia> cliente = service.findById(id);

        if (cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(cliente.get());
        }
    }

    @PostMapping
    public ResponseEntity<Deficiencia> insert(@RequestBody Deficiencia c){
        if(c.getDenominacao() == null ){
            return ResponseEntity.status(400).body(c);
        }
        Deficiencia	deficiencia = service.insert(c);
        return ResponseEntity.status(201).body(deficiencia);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Deficiencia> update(@PathVariable Long id, @RequestBody Deficiencia c){
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

