package com.ludmylla.invoice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Page<Invoice> getAllInvoice(Pageable pageable) {
		Page<Invoice> invoice = invoiceRepository.findAll(pageable);
		return invoice;
	}

	@Override
	public Invoice findById(Long id) {
		return invoiceRepository.findById(id)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice does not exist! "));
	}
	
	@Modifying
	@Transactional
	@Override
	public void updateInvoiceStatus(Invoice invoice) {
		validIfInvoiceExist(invoice.getId());
		getTheInvoiceData(invoice);
		invoiceRepository.save(invoice);
	}
	
	private Invoice getTheInvoiceData(Invoice invoice) {
		Invoice invoiceGetData = findById(invoice.getId());
		invoice.setUser(invoiceGetData.getUser());
		invoice.setCompanyName(invoiceGetData.getCompanyName());
		invoice.setDueDate(invoiceGetData.getDueDate());
		invoice.setValue(invoiceGetData.getValue());
		
		return invoice;
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
