package br.com.serratec.entity;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_vendedor")
@Entity
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Schema(description ="Nome do vendedor")
	@NotBlank(message = "Nome não pode ser vazio")
	private String nome;
	@Schema(description ="Email do vendedor")
	@Email(message =" Email deve ser válido")
	@NotBlank(message = "Email é obrigatório")
	private String email;
	@Schema(description ="Salário do vendedor")
	@NotNull
	@Min(value = 1412 , message = "Valor não pode ser inferior ao salário mínimo")
	private double salario;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@OneToMany(mappedBy = "vendedor")
	@Schema(description = "Vendas")
	private List<LancamentoVenda> vendas;


	public List<LancamentoVenda> getVendas() {
		return vendas;
	}
	public void setVendas(List<LancamentoVenda> vendas) {
		this.vendas = vendas;
	}
	
	
}
