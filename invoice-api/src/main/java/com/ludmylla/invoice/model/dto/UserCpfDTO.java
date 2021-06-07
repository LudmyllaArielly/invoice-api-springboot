package com.ludmylla.invoice.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class UserCpfDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{required.cpf}")
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
