package br.com.serratec.entity;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class LancamentoVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Identificador de vendas")
	private Long id;
	@Schema(description = "Data da venda")
	private LocalDate data;
	
	@JoinColumn(name = "vendedor_id")
	@ManyToOne
	@Schema(description = "Vendedor da venda")
	private Vendedor vendedor;
	
	@Schema(description = "Valor da venda")
	private double valor;
	
	@PrePersist
	private void onCreate() {
		this.data = LocalDate.now();
	}
	
	

	public LancamentoVenda(Long id, LocalDate data, Vendedor vendedor, double valor) {
	
		this.id = id;
		this.data = data;
		this.vendedor = vendedor;
		this.valor = valor;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
