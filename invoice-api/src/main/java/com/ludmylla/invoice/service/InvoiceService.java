package com.ludmylla.invoice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ludmylla.invoice.model.Invoice;

public interface InvoiceService {

	void createInvoice(Invoice invoice);

	Page<Invoice> getAllInvoice(Pageable pageable);

	Invoice findById(Long id);

	void updateInvoice(Invoice invoice);

	void deleteInvoice(Long id);

	void updateInvoiceStatus(Invoice invoice);
}
