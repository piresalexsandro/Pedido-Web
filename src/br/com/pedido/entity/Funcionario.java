package br.com.pedido.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private int idade;
	private BigDecimal salario;
	private Date dataAdmissao;
	private Date dataDemissao;
	
	public Funcionario() {
	}
	
	public Funcionario(Long id, String nome, String email, int idade, BigDecimal salario, Date dataAdmissao,
			Date dataDemissao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
	}

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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

}
