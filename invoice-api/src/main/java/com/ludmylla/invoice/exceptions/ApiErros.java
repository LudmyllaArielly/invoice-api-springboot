package com.ludmylla.invoice.exceptions;

import java.util.Arrays;
import java.util.List;

public class ApiErros {

	private List<String> erros;
	
	public ApiErros(UserNotFoundException ex) {
		this.erros = Arrays.asList(ex.getMessage());
	}

	public List<String> getErros() {
		return erros;
	}

	public ApiErros(List<String> erros) {

		this.erros = erros;
	}

	public ApiErros(String messageError) {
		this.erros = Arrays.asList(messageError);
	}

}
