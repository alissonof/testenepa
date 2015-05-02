package br.com.testenetshoes.controller.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.testenetshoes.controller.exception.ValidateException;
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

			validate(endereco);
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

	public void validate(Endereco endereco) throws ValidateException{

		Map<String, String> errors = new HashMap<String, String>();
		if(endereco.getRua() == null || endereco.getRua().isEmpty()){
			errors.put("rua", "Rua não preenchida");
		}

		if(endereco.getCidade() == null || endereco.getCidade().isEmpty()){
			errors.put("cidade", "Cidade não preenchida");
		}

		if(endereco.getEstado() == null || endereco.getEstado().isEmpty()){
			errors.put("estado", "Estado não preenchido");
		}

		if(endereco.getCep() == null || endereco.getCep().isEmpty()){
			errors.put("cep", "CEP não preenchido");
		}

		if(endereco.getNumero() == null || endereco.getNumero().isEmpty()){
			errors.put("numero", "Número não preenchido");
		}

		if(errors.size() > 0){
			throw new ValidateException("Erro nos seguintes Campos", errors);
		}
	}
}
