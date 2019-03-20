package br.com.pedido.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println("nome: " + nome);
		String email = req.getParameter("email");
		System.out.println("email: " + email);
		Integer idade = Integer.parseInt(req.getParameter("idade"));
		System.out.println("idade: " + idade);
		BigDecimal salario = new BigDecimal(req.getParameter("salario"));
		System.out.println("salario: " + salario);
		//Date data = new Date();
		
		resp.sendRedirect("index.html");
	}
	
}
