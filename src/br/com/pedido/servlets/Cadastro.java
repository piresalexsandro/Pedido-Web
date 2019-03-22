package br.com.pedido.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pedido.dao.FuncionarioDAO;
import br.com.pedido.dao.imp.FuncionarioDAOImp;
import br.com.pedido.entity.Funcionario;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		Integer idade = Integer.parseInt(req.getParameter("idade"));
		BigDecimal salario = new BigDecimal(req.getParameter("salario"));
		//Date data = new Date();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setEmail(email);
		funcionario.setIdade(idade);
		funcionario.setSalario(salario);
        
		FuncionarioDAO dao = new FuncionarioDAOImp(null);
		dao.insert(funcionario);
		
		resp.sendRedirect("index.html");
	}
	
}
