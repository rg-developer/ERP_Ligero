package com.prueba1.main.rest.Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "order_details",
       uniqueConstraints = @UniqueConstraint(name = "uk_order_product", columnNames = {"order_id", "product_id"}))
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private CustomerOrder order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "product_name", nullable = false, length = 150)
    private String productName;

    @Column(name = "product_sku", nullable = false, length = 50)
    private String productSku;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "tax_rate", nullable = false, precision = 5, scale = 2)
    private BigDecimal taxRate;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    @OneToMany(mappedBy = "orderDetail")
    private List<GoodsReceiptDetail> receiptDetails = new ArrayList<>();

    @OneToMany(mappedBy = "orderDetail")
    private List<InventoryMovement> inventoryMovements = new ArrayList<>();

    public OrderDetail() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public CustomerOrder getOrder() { return order; }
    public void setOrder(CustomerOrder order) { this.order = order; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductSku() { return productSku; }
    public void setProductSku(String productSku) { this.productSku = productSku; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public BigDecimal getTaxRate() { return taxRate; }
    public void setTaxRate(BigDecimal taxRate) { this.taxRate = taxRate; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    public List<GoodsReceiptDetail> getReceiptDetails() { return receiptDetails; }
    public void setReceiptDetails(List<GoodsReceiptDetail> receiptDetails) { this.receiptDetails = receiptDetails; }
    public List<InventoryMovement> getInventoryMovements() { return inventoryMovements; }
    public void setInventoryMovements(List<InventoryMovement> inventoryMovements) { this.inventoryMovements = inventoryMovements; }
}
