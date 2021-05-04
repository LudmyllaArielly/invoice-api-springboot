package com.ludmylla.invoice.model.dto;

import java.io.Serializable;

import com.ludmylla.invoice.model.enums.InvoiceStatus;

public class InvoiceUpdateStatusDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private InvoiceStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

}
