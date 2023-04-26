package com.crud.pruebatecnica.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name="Factura")

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Por favor ingrese un número de factura")
    private String invoiceNumber;
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate invoiceDate;
    private Boolean status = true; // El campo estado permite que la factura se encuentre anulada o valida
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<InvoiceDetail> invoiceDetail;
}
