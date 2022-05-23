package com.projetoweb.pagrn.controller;

import com.projetoweb.pagrn.model.Endereco;
import com.projetoweb.pagrn.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public List<Endereco> listALl(@RequestParam(required = false,defaultValue="0") Boolean asc,
                                  @RequestParam(required = false,defaultValue="id") String col,
                                  @RequestParam(required = false,defaultValue="0") int page){
        return service.listAll(asc,col,page);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Endereco> getOne(@PathVariable Long id){
        Optional<Endereco> cliente = service.findById(id);

        if (cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(cliente.get());
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

