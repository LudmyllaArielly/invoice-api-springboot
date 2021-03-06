package com.ludmylla.invoice.service;

import java.util.List;

import com.ludmylla.invoice.model.Invoice;

public interface InvoiceService {

	Long createInvoice(Invoice invoice);
	
	List<Invoice> getAllInvoice();

	Invoice findById(Long id);

	void updateInvoice(Invoice invoice);

	void deleteInvoice(Long id);

	void updateInvoiceStatus(Invoice invoice);
}
