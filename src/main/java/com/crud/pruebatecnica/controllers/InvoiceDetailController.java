package com.crud.pruebatecnica.controllers;

import com.crud.pruebatecnica.entities.InvoiceDetail;
import com.crud.pruebatecnica.services.implementation.InvoiceDetailService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detail/facturas")
public class InvoiceDetailController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping("/{facturaId}/detallefacturas")
    public List<InvoiceDetail> getInvoiceDetailByInvoiceId(@PathVariable(value = "facturaId") Long facturaId) {
        return invoiceDetailService.getInvoiceDetailByInvoiceId(facturaId);
    }

    @PostMapping("/{facturaId}/detallefacturas")
    public ResponseEntity<InvoiceDetail> createInvoiceDetail(@PathVariable(value = "facturaId") Long facturaId, @Valid @RequestBody InvoiceDetail invoiceDetail) {
        InvoiceDetail invoiceDetailNew = invoiceDetailService.createInvoiceDetail(facturaId, invoiceDetail);
        return new ResponseEntity<>(invoiceDetailNew, HttpStatus.OK);

    }

    @PutMapping("/{facturaId}/detallefacturas/{detalleFacturaId}")
    public InvoiceDetail updateInvoiceDetail(@PathVariable(value = "facturaId") Long facturaId, @PathVariable(value = "detalleFacturaId") Long detalleFacturaId, @Valid @RequestBody InvoiceDetail invoiceDetail) {
        return invoiceDetailService.updateInvoiceDetail(facturaId, detalleFacturaId, invoiceDetail);
    }

    @DeleteMapping("/{facturaId}/detallefacturas/{detalleFacturaId}")
    public ResponseEntity<?> deleteDetalleFactura(@PathVariable(value = "facturaId") Long facturaId, @PathVariable(value = "detalleFacturaId") Long detalleFacturaId) {
        invoiceDetailService.deleteInvoiceDetail(facturaId, detalleFacturaId);
        return ResponseEntity.ok().build();
    }
}
