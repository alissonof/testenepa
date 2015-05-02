package br.com.testenetshoes.controller.exception;

public class InvalidParameterExeception extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidParameterExeception(String message){
		super(message);
	}

}
