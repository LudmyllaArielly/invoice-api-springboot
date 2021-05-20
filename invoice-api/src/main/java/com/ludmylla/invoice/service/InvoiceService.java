package com.ludmylla.invoice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ludmylla.invoice.model.Invoice;

public interface InvoiceService {

	void createInvoice(Invoice invoice);

	Page<Invoice> getAllInvoices(Pageable pageable);
	
	List<Invoice> getAllInvoice();

	Invoice findById(Long id);

	void updateInvoice(Invoice invoice);

	void deleteInvoice(Long id);

	void updateInvoiceStatus(Invoice invoice);
}
