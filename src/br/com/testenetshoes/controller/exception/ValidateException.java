package br.com.testenetshoes.controller.exception;


import java.util.Map;


@SuppressWarnings("serial")
public class ValidateException extends Exception{

	private Map<String, String> map;
	
	public ValidateException(String message, Map<String, String> erros){
		super(message);
		this.map = erros;
	}
	
	public Map<String, String> getErrors(){
		return map;
	}
}
