package com.ludmylla.invoice.service;

import java.util.List;
import java.util.Optional;

import com.ludmylla.invoice.model.Invoice;

public interface InvoiceService {

	void createInvoice(Invoice invoice);
	
	List<Invoice> getAllInvoice();
	
	Optional<Invoice> findById(Long id);
}
