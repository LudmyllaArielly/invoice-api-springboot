package com.ludmylla.invoice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ludmylla.invoice.mapper.InvoiceMapper;
import com.ludmylla.invoice.model.Invoice;
import com.ludmylla.invoice.model.dto.InvoiceCreateAndListAllDTO;
import com.ludmylla.invoice.service.InvoiceService;


@RestController
@RequestMapping("/invoices")
public class InvoiceResource {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@PostMapping
	public ResponseEntity<String> createInvoice (@RequestBody InvoiceCreateAndListAllDTO invoiceCreateAndListAllDTO){
		try {
			Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(invoiceCreateAndListAllDTO);
			invoiceService.createInvoice(invoice);
			return ResponseEntity.status(HttpStatus.CREATED).body("Invoice created successfully. ");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create invoice: " + e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<InvoiceCreateAndListAllDTO>> getAllInvoice(){
		try {
			List<Invoice> list = invoiceService.getAllInvoice();
			
			List<InvoiceCreateAndListAllDTO> invoiceCreateAndListAllDTO = InvoiceMapper.INSTANCE
					.toInvoiceCreateAndListAllDTOs(list);
			return new ResponseEntity<List<InvoiceCreateAndListAllDTO>>(invoiceCreateAndListAllDTO,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<InvoiceCreateAndListAllDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
