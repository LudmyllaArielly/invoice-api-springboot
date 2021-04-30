package com.ludmylla.invoice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ludmylla.invoice.exceptions.InvoiceNotFoundException;
import com.ludmylla.invoice.model.Invoice;
import com.ludmylla.invoice.model.User;
import com.ludmylla.invoice.repository.InvoiceRepository;
import com.ludmylla.invoice.repository.UserRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createInvoice(Invoice invoice) {
		findUserByCpf(invoice);
		invoiceRepository.save(invoice);
	}
	
	private void findUserByCpf(Invoice invoice) {
		User user = userRepository.findByCpf(invoice.getUser().getCpf());
		invoice.setUser(user);
	}

	@Override
	public List<Invoice> getAllInvoice() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice findById(Long id) {
		return invoiceRepository.findById(id)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice does not exist! "));
	}
	
	@Override
	public void updateInvoiceStatus(Invoice invoice) {
		validIfInvoiceExist(invoice.getId());
		invoice.setDueDate(invoice.getDueDate());
		invoice.setCompanyName(invoice.getCompanyName());
		invoice.setUser(invoice.getUser());
		invoice.setValue(invoice.getValue());
		invoiceRepository.save(invoice);
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		findUserByCpf(invoice);
		validIfInvoiceExist(invoice.getId());
		invoiceRepository.save(invoice);
	
	}
	
	@Override
	public void deleteInvoice (Long id) {
		validIfInvoiceExist(id);
		Optional<Invoice> invoice = invoiceRepository.findById(id);
		Invoice invoices = invoice.get();
		invoiceRepository.delete(invoices);
	}
	
	private void validIfInvoiceExist(Long id) {
		Boolean isInvoiceExist = invoiceRepository.findById(id).isPresent();
		if(!isInvoiceExist) {
			throw new InvoiceNotFoundException("Invoice does not exist!");
		}
	}


}
