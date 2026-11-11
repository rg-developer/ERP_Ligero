package com.prueba1.main.rest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "goods_receipt_details",
       uniqueConstraints = @UniqueConstraint(name = "uk_receipt_order_detail",
           columnNames = {"receipt_id", "order_detail_id"}))
public class GoodsReceiptDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receipt_id", nullable = false)
    private GoodsReceipt receipt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_detail_id", nullable = false)
    private OrderDetail orderDetail;

    @Column(name = "quantity_received", nullable = false)
    private Integer quantityReceived;

    @OneToOne(mappedBy = "goodsReceiptDetail")
    private InventoryMovement inventoryMovement;

    public GoodsReceiptDetail() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public GoodsReceipt getReceipt() { return receipt; }
    public void setReceipt(GoodsReceipt receipt) { this.receipt = receipt; }
    public OrderDetail getOrderDetail() { return orderDetail; }
    public void setOrderDetail(OrderDetail orderDetail) { this.orderDetail = orderDetail; }
    public Integer getQuantityReceived() { return quantityReceived; }
    public void setQuantityReceived(Integer quantityReceived) { this.quantityReceived = quantityReceived; }
    public InventoryMovement getInventoryMovement() { return inventoryMovement; }
    public void setInventoryMovement(InventoryMovement inventoryMovement) { this.inventoryMovement = inventoryMovement; }
}
