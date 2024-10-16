package br.com.serratec.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;

@Entity
public class VendedorAutonomo extends Vendedor {
	
	@Schema(description ="Comissão do vendedor")
	private double comissao;

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

}
