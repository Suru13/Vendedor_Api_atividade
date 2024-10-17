package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.entity.LancamentoVenda;
import br.com.serratec.entity.Vendedor;

public class LancamentoVendaResponseDTO {
	
	private LocalDate data;
	private String nomeVendedor;
	private double valor;
	

	
	
	
	
	
	public LancamentoVendaResponseDTO(Vendedor vendedor,LancamentoVenda venda) {

		this.data =venda.getData();
		this.valor = venda.getValor();
		this.nomeVendedor = vendedor.getNome();
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	

}
