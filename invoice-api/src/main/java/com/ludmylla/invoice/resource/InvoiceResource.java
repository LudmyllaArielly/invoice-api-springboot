package com.ludmylla.invoice.resource;

import java.util.List;

import javax.validation.Valid;

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
import com.ludmylla.invoice.model.dto.InvoiceListAndCpfUserDTO;
import com.ludmylla.invoice.model.dto.InvoiceUpdateDTO;
import com.ludmylla.invoice.model.dto.InvoiceUpdateStatusDTO;
import com.ludmylla.invoice.service.InvoiceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/invoices")
public class InvoiceResource {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@ApiOperation(value = "Create a invoice")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created invoice successfully"),
			@ApiResponse(code = 400, message = "An exception was raised")
	})
	@PostMapping
	public ResponseEntity<String> createInvoice (@Valid @RequestBody InvoiceCreateAndListAllDTO invoiceCreateAndListAllDTO){
		try {
			Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(invoiceCreateAndListAllDTO);
			invoiceService.createInvoice(invoice);
			return ResponseEntity.status(HttpStatus.CREATED).body("Invoice created successfully. ");
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@ApiOperation(value = "Search all invoices")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Search successfully"),
			@ApiResponse(code = 400, message = "An exception was raised")
	})
	@GetMapping
	public ResponseEntity<List<InvoiceListAllDTO>> getAllInvoice(){
		try {
			List<Invoice> list = invoiceService.getAllInvoice();
			List<InvoiceListAllDTO> invoiceListAllDTOs = InvoiceMapper.INSTANCE
					.dtoInvoiceListAllDTO(list);
			return new ResponseEntity<List<InvoiceListAllDTO>>(invoiceListAllDTOs,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<InvoiceListAllDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Find the invoice by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "find the invoice successfully"),
			@ApiResponse(code = 404, message = "Invoice not found"),
			@ApiResponse(code = 400, message = "An exception was raised")
	})
	@GetMapping("/{id}")
	public ResponseEntity<InvoiceListAllDTO> findInvoiceById(@PathVariable("id") Long id) throws InvoiceNotFoundException{
		try {
			Invoice invoices = invoiceService.findById(id);
			InvoiceListAllDTO invoiceListAllDTO = InvoiceMapper.INSTANCE.dtoInvoiceListAllDTO(invoices);
			return new ResponseEntity<InvoiceListAllDTO>(invoiceListAllDTO,HttpStatus.OK);
		} catch (InvoiceNotFoundException e) {
			throw new InvoiceNotFoundException("Invoice does not exist");
		}catch (Exception e) {
			return new ResponseEntity<InvoiceListAllDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Finds invoice by id and returns all user data")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "find the invoice successfully"),
			@ApiResponse(code = 404, message = "Invoice not found"),
			@ApiResponse(code = 400, message = "An exception was raised")
	})
	@GetMapping("findInvoiceWithUserCpf/{id}")
	public ResponseEntity<InvoiceListAndCpfUserDTO> findInvoiceWithUserCpf(@PathVariable("id") Long id) throws InvoiceNotFoundException{
		try {
			Invoice invoices = invoiceService.findById(id);
			InvoiceListAndCpfUserDTO InvoiceListAndCpfUserDTO = InvoiceMapper.INSTANCE.dtoInvoiceListAndCpfUserDTO(invoices);
			return new ResponseEntity<InvoiceListAndCpfUserDTO>(InvoiceListAndCpfUserDTO,HttpStatus.OK);
		} catch (InvoiceNotFoundException e) {
			throw new InvoiceNotFoundException("Invoice does not exist");
		}catch (Exception e) {
			return new ResponseEntity<InvoiceListAndCpfUserDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Updated status of the invoice")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Updated status invoice successfully"),
			@ApiResponse(code = 400, message = "An exception was raised")
	})
	@PatchMapping("/status")
	public ResponseEntity<String> updateInvoiceStatus (@Valid @RequestBody InvoiceUpdateStatusDTO updateStatusDTO){
		try {
			Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(updateStatusDTO);
			invoiceService.updateInvoiceStatus(invoice);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully updated invoice status! ");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@ApiOperation(value = "Updated the invoice")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Updated invoice successfully"),
			@ApiResponse(code = 400, message = "An exception was raised")
	})
	@PutMapping
	public ResponseEntity<String> updatedInvoice(@Valid @RequestBody InvoiceUpdateDTO invoiceUpdateDTO){
		try {
			Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(invoiceUpdateDTO);
			invoiceService.updateInvoice(invoice);
			return ResponseEntity.status(HttpStatus.OK).body("Invoice updated successfully! ");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@ApiOperation(value = "Deleted the invoice")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Deleted invoice successfully"),
			@ApiResponse(code = 404, message = "Invoice not found"),
			@ApiResponse(code = 400, message = "An exception was raised")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInvoice( @PathVariable("id") Long id){
		try {
			invoiceService.deleteInvoice(id);
			return ResponseEntity.noContent().build();
		} catch (InvoiceNotFoundException e) {
			throw new InvoiceNotFoundException("Invoice does not exist! ");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
