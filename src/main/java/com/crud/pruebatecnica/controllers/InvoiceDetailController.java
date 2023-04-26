package com.crud.pruebatecnica.controllers;

import com.crud.pruebatecnica.entities.InvoiceDetail;
import com.crud.pruebatecnica.services.implementation.InvoiceDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/detail")
public class InvoiceDetailController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping("/facturas/{facturaId}/detallefacturas")
    public List<InvoiceDetail> getInvoiceDetailByInvoiceId(@PathVariable(value = "facturaId") Long facturaId) {
        return invoiceDetailService.getInvoiceDetailByInvoiceId(facturaId);
    }

    @PostMapping("/facturas/{facturaId}/detallefacturas")
    public InvoiceDetail createInvoiceDetail(@PathVariable(value = "facturaId") Long facturaId, @Valid @RequestBody InvoiceDetail invoiceDetail) {
        return invoiceDetailService.createInvoiceDetail(facturaId, invoiceDetail);
    }

    @PutMapping("/facturas/{facturaId}/detallefacturas/{detalleFacturaId}")
    public InvoiceDetail updateInvoiceDetail(@PathVariable(value = "facturaId") Long facturaId, @PathVariable(value = "detalleFacturaId") Long detalleFacturaId, @Valid @RequestBody InvoiceDetail invoiceDetail) {
        return invoiceDetailService.updateInvoiceDetail(facturaId, detalleFacturaId, invoiceDetail);
    }

    @DeleteMapping("/facturas/{facturaId}/detallefacturas/{detalleFacturaId}")
    public ResponseEntity<?> deleteDetalleFactura(@PathVariable(value = "facturaId") Long facturaId, @PathVariable(value = "detalleFacturaId") Long detalleFacturaId) {
        invoiceDetailService.deleteInvoiceDetail(facturaId, detalleFacturaId);
        return ResponseEntity.ok().build();
    }
}
