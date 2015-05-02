package br.com.testenetshoes.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.testenetshoes.model.entity.Endereco;
import br.com.testenetshoes.model.service.EnderecoService;

public class ListarEnderecoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		
		EnderecoService eService = new EnderecoService();
		try {
			List<Endereco> listEndereco = eService.listAll();
			request.setAttribute("listaEndereco", listEndereco);
		} catch (Exception e) {
			request.setAttribute("message", "Erro: "+e.getMessage());
		}
		
		String url = "listaendereco.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);

		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
