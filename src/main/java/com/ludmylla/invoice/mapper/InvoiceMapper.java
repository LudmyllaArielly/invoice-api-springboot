package com.ludmylla.invoice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ludmylla.invoice.model.Invoice;
import com.ludmylla.invoice.model.dto.InvoiceCreateAndListAllDTO;

@Mapper(uses = {UserMapper.class})
public interface InvoiceMapper {
	
	InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);
	
	@Mapping(target ="id", ignore = true)
	@Mapping(target ="user", source = "userCpfDTO")
	Invoice toInvoice (InvoiceCreateAndListAllDTO source);
	
	@Mapping(target ="user", source = "userCpfDTO")
	List<InvoiceCreateAndListAllDTO> toInvoiceCreateAndListAllDTOs (List<Invoice> souce);
	

}
