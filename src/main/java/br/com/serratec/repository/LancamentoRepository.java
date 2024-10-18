package br.com.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.LancamentoVenda;

public interface LancamentoRepository extends JpaRepository<LancamentoVenda, Long> {
	
	Optional<LancamentoVenda> findByNome(String nome);

	Optional<LancamentoVenda> findByEmail(String email);

	
	

}
