package com.projetoweb.pagrn.controller;

import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.model.Servidor;
import com.projetoweb.pagrn.service.PessoaService;
import dto.PessoaDtoResponse;
import dto.ServidorDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;

	/*
	@GetMapping
	public List<Pessoa> listALl(@RequestParam(required = false,defaultValue="0") Boolean asc,
								@RequestParam(required = false,defaultValue="id") String col,
								@RequestParam(required = false,defaultValue="0") int page){
		return service.listAll(asc,col,page);
	}*/

	@GetMapping
	public ResponseEntity<Page<PessoaDtoResponse>>listAll(@PageableDefault(size = 10) Pageable pageable){
		Page<Pessoa> list = service.listAll(pageable);

		Page<PessoaDtoResponse> listDTO = list.map(obj -> new PessoaDtoResponse(obj));

		return ResponseEntity.ok(listDTO);
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
		Pessoa	pessoa = service.insert(c);
		return ResponseEntity.status(201).body(pessoa);
	}

	@PutMapping(path = {"/{id}"})
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa c){
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
	
