package com.example.demo.repositoriy;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
