package br.com.pedido.dao;

import br.com.pedido.connection.MySqlConnection;
import br.com.pedido.dao.imp.FuncionarioDAOImp;

public class Daofactory {
	
	public static FuncionarioDAO createFuncioanrioDAO() {
		return new FuncionarioDAOImp(MySqlConnection.getConnection());
	}
}