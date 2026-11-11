package com.prueba1.main.rest.Models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "product_suppliers",
       uniqueConstraints = @UniqueConstraint(name = "uk_product_supplier", columnNames = {"product_id", "supplier_id"}))
public class ProductSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Column(name = "supplier_reference", length = 80)
    private String supplierReference;

    @Column(name = "purchase_price", precision = 12, scale = 2)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private boolean preferred = false;

    public ProductSupplier() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public String getSupplierReference() { return supplierReference; }
    public void setSupplierReference(String supplierReference) { this.supplierReference = supplierReference; }
    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }
    public boolean isPreferred() { return preferred; }
    public void setPreferred(boolean preferred) { this.preferred = preferred; }
}
