package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Vendedor;
import br.com.serratec.repository.VendedorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
    @Autowired
	private VendedorRepository repository;
    
    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor inserir(@Valid @RequestBody Vendedor v) {
		return repository.save(v);
	}
    
    @PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Vendedor> inserirVarios(@RequestBody List<Vendedor> vendedores) {
		return repository.saveAll(vendedores);
	}

    @GetMapping
	public List<Vendedor> listar() {
		return repository.findAll();
	}
    
    



}