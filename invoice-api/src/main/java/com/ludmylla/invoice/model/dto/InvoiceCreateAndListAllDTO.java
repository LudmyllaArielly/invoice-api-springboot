package com.ludmylla.invoice.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.ludmylla.invoice.model.enums.InvoiceStatus;

public class InvoiceCreateAndListAllDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "{required.companyName}")
	private String companyName;
	
	@NotNull(message = "{required.value}")
	@DecimalMin(value = "0.00")
	private BigDecimal value;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@NotNull(message = "{required.dueDate}")
	private LocalDate dueDate;
	
	@NotNull(message = "{required.status}")
	private InvoiceStatus status;
	
	@NotNull(message = "{required.user}")
	private UserCpfDTO userCpfDTO;

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
