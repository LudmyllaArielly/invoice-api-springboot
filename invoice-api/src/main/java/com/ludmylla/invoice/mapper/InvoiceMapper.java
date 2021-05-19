package com.ludmylla.invoice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.ludmylla.invoice.model.Invoice;
import com.ludmylla.invoice.model.dto.InvoiceCreateAndListAllDTO;
import com.ludmylla.invoice.model.dto.InvoiceListAllDTO;
import com.ludmylla.invoice.model.dto.InvoiceListAndCpfUserDTO;
import com.ludmylla.invoice.model.dto.InvoiceUpdateDTO;
import com.ludmylla.invoice.model.dto.InvoiceUpdateStatusDTO;

@Mapper(uses = {UserMapper.class})
public interface InvoiceMapper {
	
	InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);
	
	@Mapping(target ="id", ignore = true)
	@Mapping(target ="user", source = "userCpfDTO")
	Invoice toInvoice (InvoiceCreateAndListAllDTO source);
	
	@Mapping(target ="userCreateAndListAllDTO", source = "user")
	InvoiceListAllDTO dtoInvoiceListAllDTO (Invoice source);
	
	List<InvoiceListAllDTO> dtoInvoiceListAllDTO(List<Invoice> souce);

	@Mapping(target ="userCpfDTO", source = "user")
	InvoiceListAndCpfUserDTO dtoInvoiceListAndCpfUserDTO (Invoice source);
	
	List<InvoiceListAndCpfUserDTO>  dtoInvoiceListAndCpfUserDTO(List<Invoice> source);
	
	@Mapping(target = "user", source = "userCpfDTO")
	Invoice toInvoice (InvoiceUpdateDTO source);
	
	@Mappings({
		@Mapping(target = "dueDate", ignore = true),
		@Mapping(target = "user", ignore = true),
		@Mapping(target = "value", ignore = true),
		@Mapping(target = "companyName", ignore = true),
	})
	Invoice toInvoice (InvoiceUpdateStatusDTO source);

	
}
