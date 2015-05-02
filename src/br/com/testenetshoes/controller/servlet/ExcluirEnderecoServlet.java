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

public class ExcluirEnderecoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String message = null;
		try {
			
			int id = Integer.parseInt(request.getParameter("id")); 
			EnderecoService eService = new EnderecoService();
			eService.delete(id);
			List<Endereco> listEndereco = eService.listAll();
			message = "Endereço excluído com Sucesso!!";
			request.setAttribute("listaEndereco", listEndereco);
		} catch (Exception e) {
			message = "Erro: "+e.getMessage();
		}

		request.setAttribute("message" , message);
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
