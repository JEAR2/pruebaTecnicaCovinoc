package com.crud.pruebatecnica.repositories;

import com.crud.pruebatecnica.entities.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {
    List<InvoiceDetail> findByInvoiceId(Long invoiceId);
}
