package com.ludmylla.invoice.service;

import java.util.List;

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
	public void updateInvoice(Invoice invoice) {
		findUserByCpf(invoice);
		invoiceRepository.save(invoice);
	}

}
