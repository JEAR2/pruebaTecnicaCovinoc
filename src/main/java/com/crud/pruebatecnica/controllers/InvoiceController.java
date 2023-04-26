package com.crud.pruebatecnica.controllers;

import com.crud.pruebatecnica.entities.Invoice;
import com.crud.pruebatecnica.services.implementation.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/facturas")
    public List<Invoice> getAllFacturas() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/facturas/{id}")
    public Invoice getInvoiceById(@PathVariable(value = "id") Long id) {
        return invoiceService.getInvoiceById(id);
    }

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createFactura(@Valid @RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @PutMapping("/facturas/{id}")
    public Invoice updateInvoice(@PathVariable(value = "id") Long id, @Valid @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    @DeleteMapping("/facturas/{id}")
    public ResponseEntity<?> deleteFactura(@PathVariable(value = "id") Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok().build();
    }
}
