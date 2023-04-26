package com.crud.pruebatecnica.services.interfaces;

import com.crud.pruebatecnica.entities.Invoice;

import java.util.List;

public interface IInvoiceService {
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(Long id);
    Invoice createInvoice(Invoice invoice);
    Invoice updateInvoice(Long id, Invoice invoice);
    void deleteInvoice(Long id);
}
