package com.ludmylla.invoice.model.dto;

import java.io.Serializable;

public class UserCpfDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
