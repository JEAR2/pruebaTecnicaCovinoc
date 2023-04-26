package com.crud.pruebatecnica.services.implementation;

import com.crud.pruebatecnica.entities.Invoice;
import com.crud.pruebatecnica.repositories.InvoiceRepository;
import com.crud.pruebatecnica.services.interfaces.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Factura no encontrada"));
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Long id, Invoice invoice) {
        Invoice findInvoice = getInvoiceById(id);
        findInvoice.setInvoiceDetail(invoice.getInvoiceDetail());
        return invoiceRepository.save(findInvoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        Invoice findInvoice = getInvoiceById(id);
        findInvoice.setStatus(false);
        invoiceRepository.save(findInvoice);
    }
}
