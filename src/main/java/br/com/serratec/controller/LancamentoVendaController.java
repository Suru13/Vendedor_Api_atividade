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

import br.com.serratec.entity.LancamentoVenda;
import br.com.serratec.repository.LancamentoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendas")
public class LancamentoVendaController {
	
	@Autowired
	private LancamentoRepository repository;
    
    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LancamentoVenda inserir(@Valid @RequestBody  LancamentoVenda venda) {
		return repository.save(venda);
	}
    
    @PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<LancamentoVenda> inserirVarios(@RequestBody List<LancamentoVenda> vendas) {
		return repository.saveAll(vendas);
	}

    @GetMapping
	public List<LancamentoVenda> listar() {
		return repository.findAll();
		
	}
    

}
