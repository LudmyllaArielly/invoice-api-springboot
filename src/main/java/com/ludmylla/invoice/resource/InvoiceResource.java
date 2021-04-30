package com.ludmylla.invoice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ludmylla.invoice.exceptions.InvoiceNotFoundException;
import com.ludmylla.invoice.mapper.InvoiceMapper;
import com.ludmylla.invoice.model.Invoice;
import com.ludmylla.invoice.model.dto.InvoiceCreateAndListAllDTO;
import com.ludmylla.invoice.model.dto.InvoiceListAllDTO;
import com.ludmylla.invoice.model.dto.InvoiceUpdateDTO;
import com.ludmylla.invoice.model.dto.InvoiceUpdateStatusDTO;
import com.ludmylla.invoice.service.InvoiceService;

@CrossOrigin(origins = "")
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
	public ResponseEntity<List<InvoiceListAllDTO>> getAllInvoice(){
		try {
			List<Invoice> list = invoiceService.getAllInvoice();
			
			List<InvoiceListAllDTO> InvoiceListAllDTO = InvoiceMapper.INSTANCE
					.dtoInvoiceListAllDTO(list);
			return new ResponseEntity<List<InvoiceListAllDTO>>(InvoiceListAllDTO,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<InvoiceListAllDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InvoiceListAllDTO> findInvoiceById(@PathVariable("id") Long id) throws InvoiceNotFoundException{
		try {
			Invoice invoices = invoiceService.findById(id);
			InvoiceListAllDTO invoiceListAllDTO = InvoiceMapper.INSTANCE.dtoInvoiceListAllDTO(invoices);
			return new ResponseEntity<InvoiceListAllDTO>(invoiceListAllDTO,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<InvoiceListAllDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/status")
	public ResponseEntity<String> updateInvoiceStatus (@RequestBody InvoiceUpdateStatusDTO updateStatusDTO){
		try {
			Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(updateStatusDTO);
			invoiceService.updateInvoiceStatus(invoice);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully updated invoice status! ");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update invoice status: " + e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<String> updatedInvoice(@RequestBody InvoiceUpdateDTO invoiceUpdateDTO){
		try {
			
			Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(invoiceUpdateDTO);
			invoiceService.updateInvoice(invoice);
			return ResponseEntity.status(HttpStatus.OK).body("Invoice updated successfully! ");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update invoice: " + e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInvoice( @PathVariable("id") Long id){
		try {
			invoiceService.deleteInvoice(id);
			return ResponseEntity.status(HttpStatus.OK).body("Invoice deleted successfully! ");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete invoice: " + e.getMessage());
		}
	}
	
	
}
