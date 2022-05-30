package com.projetoweb.pagrn.controller;

import com.projetoweb.pagrn.model.Deficiencia;
import com.projetoweb.pagrn.service.DeficienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/deficiencia")
public class DeficienciaController {

    @Autowired
    private DeficienciaService service;

    @GetMapping
    public List<Deficiencia> listALl(@RequestParam(required = false,defaultValue="0") Boolean asc,
                                     @RequestParam(required = false,defaultValue="id") String col,
                                     @RequestParam(required = false,defaultValue="0") int page){
        return service.listAll(asc,col,page);
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
        Deficiencia	deficiencia = service.insert(c);
        return ResponseEntity.status(201).body(deficiencia);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Deficiencia> update(@PathVariable Long id, @RequestBody Deficiencia c){
        c.setId(id);
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

