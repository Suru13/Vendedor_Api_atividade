package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.LancamentoVenda;

public interface LancamentoVendaRepository extends JpaRepository<LancamentoVenda, Long> {
	
	

}