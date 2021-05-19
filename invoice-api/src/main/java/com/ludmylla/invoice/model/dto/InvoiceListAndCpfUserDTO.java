package com.ludmylla.invoice.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ludmylla.invoice.model.enums.InvoiceStatus;

public class InvoiceListAndCpfUserDTO {

	private Long id;
	private String companyName;
	private BigDecimal value;
	private LocalDate dueDate;

	private InvoiceStatus status;

	private UserCpfDTO userCpfDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	public UserCpfDTO getUserCpfDTO() {
		return userCpfDTO;
	}

	public void setUserCpfDTO(UserCpfDTO userCpfDTO) {
		this.userCpfDTO = userCpfDTO;
	}

}
