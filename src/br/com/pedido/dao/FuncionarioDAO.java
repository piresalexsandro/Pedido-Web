package br.com.pedido.dao;

import java.util.List;

import br.com.pedido.entity.Funcionario;

public interface FuncionarioDAO {

	void insert(Funcionario obj);
	void update(Funcionario obj);
	void deleteById(Integer id);
	Funcionario findById(Integer id);
	List<Funcionario> findAll();
	
}
