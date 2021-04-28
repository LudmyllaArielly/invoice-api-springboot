package com.ludmylla.invoice.service;

import java.util.List;

import com.ludmylla.invoice.model.Invoice;

public interface InvoiceService {

	void createInvoice(Invoice invoice);
	
	List<Invoice> getAllInvoice();
	
	Invoice findById(Long id);
}
