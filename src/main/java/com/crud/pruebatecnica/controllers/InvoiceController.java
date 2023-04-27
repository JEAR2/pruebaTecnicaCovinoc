package com.crud.pruebatecnica.controllers;

import com.crud.pruebatecnica.entities.Invoice;
import com.crud.pruebatecnica.services.implementation.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping()
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable(value = "id") Long id) {
        return invoiceService.getInvoiceById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoce(@Valid @RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable(value = "id") Long id, @Valid @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFactura(@PathVariable(value = "id") Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok().build();
    }
}
