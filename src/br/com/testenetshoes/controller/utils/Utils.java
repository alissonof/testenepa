package br.com.testenetshoes.controller.utils;

import java.util.HashMap;
import java.util.Map;

import br.com.testenetshoes.controller.exception.ValidateException;
import br.com.testenetshoes.model.entity.Endereco;


public class Utils {

	/**
	 * Verifica se String passada � nula ou esta vazia.
	 * @param param String a ser an�lizada.
	 * @return true se estiver nulo ou vazio. false caso não esteja nulo ou vazio.
	 */
	public static boolean isNull(String param){
		if(param == null || param.isEmpty()){
			return true;
		}

		return false;
	}
	
	/**
	 * valida para ver se os campos do endereço que são obrigatórios
	 * foram preenchidos corretamente antes de presistir
	 * @param endereco objeto que será validado
	 * @throws ValidateException Caso algum campo seja inválido
	 */
	public static void validate(Endereco endereco) throws ValidateException{

		Map<String, String> errors = new HashMap<String, String>();
		if(Utils.isNull(endereco.getRua())){
			errors.put("rua", "Rua não preenchida");
		}

		if(endereco.getCidade() == null || endereco.getCidade().isEmpty()){
			errors.put("cidade", "Cidade não preenchida");
		}

		if(Utils.isNull(endereco.getEstado())){
			errors.put("estado", "Estado não preenchido");
		}

		if(Utils.isNull(endereco.getCep())){
			errors.put("cep", "CEP não preenchido");
		}

		if(Utils.isNull(endereco.getNumero())){
			errors.put("numero", "Número não preenchido");
		}

		if(errors.size() > 0){
			throw new ValidateException("Erro nos seguintes Campos", errors);
		}
	}
	
}
