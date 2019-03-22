package br.com.pedido.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import br.com.pedido.connection.MySqlConnection;
import br.com.pedido.connection.MySqlException;
import br.com.pedido.dao.FuncionarioDAO;
import br.com.pedido.entity.Funcionario;

public class FuncionarioDAOImp implements FuncionarioDAO {

	private Connection conn;
	
	public FuncionarioDAOImp(Connection conn) {
		this.conn = conn;
	}

	private Funcionario instatiateFuncionario(ResultSet rs) throws SQLException {
		Funcionario dep = new Funcionario();
		dep.setId(rs.getLong("Id"));
		dep.setNome(rs.getString("Name"));
		return dep;
	}
			
	@Override
	public void insert(Funcionario obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					   "INSERT INTO funcionario " + 
							   "(CD_FUN), " + 	
							   "(NM_FUN), " + 	
							   "(EMAIL_FUN), " + 
							   "(IDADE), " + 	
							   "(DT_ADMIS), " + 
							   "(DT_DEMIS), " + 
							   "(VL_SAL) " + 	
							   "VALUES (NULL,?,?,?,?,?,?)",
					   Statement.RETURN_GENERATED_KEYS
 					   );
			
			st.setString(1, obj.getNome());
		
			int rowsAffected = st.executeUpdate();
		}
		catch(SQLException e) {
			throw new MySqlException(e.getMessage());
		}
		finally {
			MySqlConnection.closeStatement(st);
		}
		
	}

	@Override
	public void update(Funcionario obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE Funcionario "
					+  "SET NM_FUN      = ? " 
					+  "   ,EMAIL_FUN   = ? "
					+  "   ,IDADE	  	= ? " 
					+  "   ,DT_ADMIS    = ? "
					+  "   ,DT_DEMIS    = ? "
					+  "   ,VL_SAL	  	= ? " 
			//+  "   ,DT_CRIACAO  = ? "
					+"WHERE CD_FUN = ? "
							);
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEmail());
			st.setInt(3, obj.getIdade());
			st.setDate(4, obj.getDataAdmissao());
			st.setDate(5, obj.getDataDemissao());
			st.setBigDecimal(6, obj.getSalario());
		//  st.setDate(7, obj.getData());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new MySqlException(e.getMessage());
		}
		finally {
			MySqlConnection.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM Funcionario WHERE CD_FUN = ?");
			
			st.setLong(1, id);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new MySqlException(e.getMessage());
		}
		finally {
			MySqlConnection.closeStatement(st);
		}
	}

	@Override
	public Funcionario findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					   "SELECT FUNCIONARIO.* "
				     +   "FROM FUNCIONARIO " 
				     +  "WHERE CD_FUN = ? ");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			//next pq a posição 0 e nula entao pegarmos a proximas
			if (rs.next()) {
				Funcionario fun = instatiateFuncionario(rs);				
				return fun;
			}
			return null;
		}
		catch(SQLException e) {
			throw new MySqlException(e.getMessage());
		}
		finally {
			MySqlConnection.closeStatement(st);
			MySqlConnection.closeResultSet(rs);
		}
	}

	@Override
	public List<Funcionario> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					        "SELECT *"
					      + "  FROM Funcionario ");
					
			rs = st.executeQuery();

			List<Funcionario> Funcionarios = new ArrayList<>();
			Map<Long, String> map = new HashMap<>();
			
			while (rs.next()) {
				String obj = map.get(rs.getLong("Id"));
				Funcionario fun = instatiateFuncionario(rs);	
				
				if (obj == null) {
					fun = instatiateFuncionario(rs);	
					map.put(rs.getLong("Id"), rs.getString("Nome"));
				}	
				
				Funcionarios.add(fun);
			}
			return Funcionarios;
		}
		catch(SQLException e) {
			throw new MySqlException(e.getMessage());
		}
		finally {
			MySqlConnection.closeStatement(st);
			MySqlConnection.closeResultSet(rs);
		}
	}

}
