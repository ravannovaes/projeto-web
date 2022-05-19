package com.projetoweb.pagrn.controller;

import java.util.List;
import java.util.Optional;

import com.projetoweb.pagrn.model.Deficiencia;
import com.projetoweb.pagrn.service.DeficienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.service.PessoaService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("/deficiencia")
public class DeficienciaController {

    @Autowired
    private DeficienciaService service;

    @GetMapping
    public ResponseEntity<List<Deficiencia>> listALl(){
        //return service.listAll();
        List<Deficiencia> deficienciaList = service.listAll();
        if(deficienciaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            for(Deficiencia d : deficienciaList){
                long id = d.getId();
                d.add(linkTo(methodOn(DeficienciaController.class).getOne(id)).withSelfRel());
            }
            return new ResponseEntity<List<Deficiencia>>(deficienciaList,HttpStatus.OK);
        }
    }

    @GetMapping(path = {"pages/{page}"})
    public List<Deficiencia> listPages(@PathVariable Long page){
        if(page!= null && !page.equals(null)){
            return service.paginatedList(page);
        }
        return service.listAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Deficiencia> getOne(@PathVariable Long id){
        Optional<Deficiencia> deficiencia = service.findById(id);

        if (deficiencia.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            //return ResponseEntity.notFound().build();
        }else{
            deficiencia.get().add(linkTo(methodOn(DeficienciaController.class).listALl()).withRel("Lista de deficiências"));
            return new ResponseEntity<Deficiencia>(deficiencia.get(),HttpStatus.OK);
            //return ResponseEntity.ok(cliente.get());
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

