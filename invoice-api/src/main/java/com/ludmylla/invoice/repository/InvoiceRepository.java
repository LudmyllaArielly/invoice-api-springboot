package com.ludmylla.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ludmylla.invoice.model.Invoice;

@Repository
@Transactional
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
