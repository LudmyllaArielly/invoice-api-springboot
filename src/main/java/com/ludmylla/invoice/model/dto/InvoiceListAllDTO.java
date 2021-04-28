package com.ludmylla.invoice.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.ludmylla.invoice.model.enums.InvoiceStatus;

public class InvoiceListAllDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String companyName;
	private BigDecimal value;
	private Date dueDate;

	private InvoiceStatus status;

	private UserCreateAndListAllDTO userCreateAndListAllDTO;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	public UserCreateAndListAllDTO getUserCreateAndListAllDTO() {
		return userCreateAndListAllDTO;
	}

	public void setUserCreateAndListAllDTO(UserCreateAndListAllDTO userCreateAndListAllDTO) {
		this.userCreateAndListAllDTO = userCreateAndListAllDTO;
	}

	
}
