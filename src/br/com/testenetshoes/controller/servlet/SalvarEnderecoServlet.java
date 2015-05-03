package br.com.testenetshoes.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.testenetshoes.controller.exception.ValidateException;
import br.com.testenetshoes.controller.utils.Utils;
import br.com.testenetshoes.model.entity.Endereco;
import br.com.testenetshoes.model.service.EnderecoService;

public class SalvarEnderecoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response){
		Endereco endereco = new Endereco();
		String message = null;
		try {
			endereco.setCep(request.getParameter("cep"));
			endereco.setRua(request.getParameter("rua"));
			endereco.setNumero(request.getParameter("numero"));
			endereco.setComplemento(request.getParameter("complemento"));
			endereco.setBairro(request.getParameter("bairro"));
			endereco.setCidade(request.getParameter("cidade"));
			endereco.setEstado(request.getParameter("estado"));

			Utils.validate(endereco);
			EnderecoService eService = new EnderecoService();
			eService.save(endereco);
			message = "Dados inseridos com Sucesso";
		} catch (ValidateException e) {
			request.setAttribute("errors" , e.getErrors());
		} catch (Exception e) {
			message = "Erro: "+e.getMessage();
		}

		request.setAttribute("message" , message);

		String url = "consultacep.jsp";
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
