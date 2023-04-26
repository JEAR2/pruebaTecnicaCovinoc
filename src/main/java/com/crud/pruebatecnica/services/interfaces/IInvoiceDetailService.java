package com.crud.pruebatecnica.services.interfaces;

import com.crud.pruebatecnica.entities.Invoice;
import com.crud.pruebatecnica.entities.InvoiceDetail;

import java.util.List;

public interface IInvoiceDetailService {
    List<InvoiceDetail> getInvoiceDetailByInvoiceId(Long invoiceId);
    InvoiceDetail createInvoiceDetail(Long invoiceId,InvoiceDetail invoiceDetail);
    InvoiceDetail updateInvoiceDetail(Long invoiceId, Long invoiceDetailId, InvoiceDetail invoiceDetail);
    void deleteInvoiceDetail(Long invoiceId, Long invoiceDetailId);
}
