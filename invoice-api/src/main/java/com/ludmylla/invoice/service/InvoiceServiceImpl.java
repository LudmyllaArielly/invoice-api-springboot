package com.ludmylla.invoice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Transactional
	@Override
	public Long createInvoice(Invoice invoice) {
		findUserByCpf(invoice);
		Invoice invoiceCreated = invoiceRepository.save(invoice);
		return invoiceCreated.getId();
	}
	
	@Transactional(readOnly = true)
	private void findUserByCpf(Invoice invoice) {
		User user = userRepository.findByCpf(invoice.getUser().getCpf());
		invoice.setUser(user);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Invoice> getAllInvoice() {
		List<Invoice> list = new ArrayList<Invoice>();
		List<Invoice> invoice = invoiceRepository.findAll();
		list.forEach(invoice::add);
		return list;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Invoice findById(Long id) {
		return invoiceRepository.findById(id)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice does not exist! "));
	}
	
	@Modifying
	@Transactional
	@Override
	public void updateInvoiceStatus(Invoice invoice) {
		validationsStatusUpdate(invoice);
		invoiceRepository.save(invoice);
	}
	
	@Transactional(readOnly = true)
	private Invoice getTheInvoiceData(Invoice invoice) {
		Invoice invoiceGetData = findById(invoice.getId());
		invoice.setUser(invoiceGetData.getUser());
		invoice.setCompanyName(invoiceGetData.getCompanyName());
		invoice.setDueDate(invoiceGetData.getDueDate());
		invoice.setValue(invoiceGetData.getValue());
		return invoice;
	}
	
	@Transactional
	@Override
	public void updateInvoice(Invoice invoice) {
		validationsUpdate(invoice);
		invoiceRepository.save(invoice);
	}
	
	@Transactional
	@Override
	public void deleteInvoice (Long id) {
		validIfInvoiceExist(id);
		Optional<Invoice> invoice = invoiceRepository.findById(id);
		Invoice invoices = invoice.get();
		invoiceRepository.delete(invoices);
	}
	
	private void validationsUpdate(Invoice invoice) {
		findUserByCpf(invoice);
		validIfInvoiceExist(invoice.getId());
	}
	
	private void validationsStatusUpdate(Invoice invoice) {
		validIfInvoiceExist(invoice.getId());
		getTheInvoiceData(invoice);
	}

	private void validIfInvoiceExist(Long id) {
		findById(id);
	}
}
