package br.com.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.LancamentoResponseDTO;
import br.com.serratec.entity.LancamentoVenda;
import br.com.serratec.exception.NaoEncontradoException;
import br.com.serratec.repository.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public List<LancamentoResponseDTO> listar() {
		List<LancamentoVenda> vendas = repository.findAll();
		List<LancamentoResponseDTO> dtos = new ArrayList<>();
		for (LancamentoVenda venda : vendas) {
			dtos.add(new LancamentoResponseDTO(venda));
		}
		return dtos;
	}
	
	public LancamentoResponseDTO listarById (Long id) {
		Optional<LancamentoVenda> vendasOptional = repository.findById(id);
		if(vendasOptional.isEmpty()) {
			throw new NaoEncontradoException("Lancamento venda não encontrado");
		}
		return new LancamentoResponseDTO(vendasOptional.get());
	}

	/*public LancamentoRequestDTO inserir(LancamentoVenda venda) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));

		return new UsuarioRequestDTO(repository.save(usuario));
	}*/

}
