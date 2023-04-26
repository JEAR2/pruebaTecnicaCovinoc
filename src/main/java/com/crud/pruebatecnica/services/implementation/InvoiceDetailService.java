package com.crud.pruebatecnica.services.implementation;

import com.crud.pruebatecnica.entities.Invoice;
import com.crud.pruebatecnica.entities.InvoiceDetail;
import com.crud.pruebatecnica.exceptions.BadRequestException;
import com.crud.pruebatecnica.exceptions.ResourceNotFoundException;
import com.crud.pruebatecnica.repositories.InvoiceDetailRepository;
import com.crud.pruebatecnica.repositories.InvoiceRepository;
import com.crud.pruebatecnica.services.interfaces.IInvoiceDetailService;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailService implements IInvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public List<InvoiceDetail> getInvoiceDetailByInvoiceId(Long invoiceId) {
        return invoiceDetailRepository.findByInvoiceId(invoiceId);
    }

    @Override
    public InvoiceDetail createInvoiceDetail(Long invoiceId,InvoiceDetail invoiceDetail) {
        Invoice invoice = getInvoiceById(invoiceId);
        invoiceDetail.setInvoice(invoice);
        return invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public InvoiceDetail updateInvoiceDetail(Long invoiceId, Long invoiceDetailId, InvoiceDetail invoiceDetail) {
        Invoice invoice = getInvoiceById(invoiceId);
        InvoiceDetail findInvoiceDetail = invoiceDetailRepository.findById(invoiceDetailId).orElseThrow(()->new ResourceNotFoundException("El detalle con id "+invoiceDetailId+"para la factura con id "+invoiceId+" no existe"));
        if (!invoice.getId().equals(findInvoiceDetail.getInvoice().getId())) {
            throw new InvalidRequestStateException("Factura no valida");
        }
        findInvoiceDetail.setCantidad(invoiceDetail.getCantidad());
        findInvoiceDetail.setPrecio(invoiceDetail.getPrecio());
        return invoiceDetailRepository.save(findInvoiceDetail);
    }

    @Override
    public void deleteInvoiceDetail(Long invoiceId, Long invoiceDetailId) {
        Invoice invoice = getInvoiceById(invoiceId);
        InvoiceDetail findInvoiceDetail = invoiceDetailRepository.findById(invoiceDetailId).orElseThrow(()->new ResourceNotFoundException("El detalle con id "+invoiceDetailId+"para la factura con id "+invoiceId+" no existe"));
        if (!invoice.getId().equals(findInvoiceDetail.getInvoice().getId())) {
            throw new InvalidRequestStateException("Factura no valida");
        }
        invoiceDetailRepository.delete(findInvoiceDetail);
    }


    private Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow(()->new BadRequestException("Id de factura  "+id+" no valido"));
    }
}
