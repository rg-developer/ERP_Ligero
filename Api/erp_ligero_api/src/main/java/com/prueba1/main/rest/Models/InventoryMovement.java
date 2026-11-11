package com.prueba1.main.rest.Models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.prueba1.main.rest.Enums.InventoryMovementType;

@Entity
@Table(name = "inventory_movements", indexes = {
    @Index(name = "idx_movement_product_date", columnList = "product_id, created_at"),
    @Index(name = "idx_movement_user", columnList = "user_id")
})
public class InventoryMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type", nullable = false, length = 30)
    private InventoryMovementType movementType;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "previous_stock", nullable = false)
    private Integer previousStock;

    @Column(name = "new_stock", nullable = false)
    private Integer newStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_receipt_detail_id", unique = true)
    private GoodsReceiptDetail goodsReceiptDetail;

    @Column(length = 255)
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); }

    public InventoryMovement() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public InventoryMovementType getMovementType() { return movementType; }
    public void setMovementType(InventoryMovementType movementType) { this.movementType = movementType; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Integer getPreviousStock() { return previousStock; }
    public void setPreviousStock(Integer previousStock) { this.previousStock = previousStock; }
    public Integer getNewStock() { return newStock; }
    public void setNewStock(Integer newStock) { this.newStock = newStock; }
    public OrderDetail getOrderDetail() { return orderDetail; }
    public void setOrderDetail(OrderDetail orderDetail) { this.orderDetail = orderDetail; }
    public GoodsReceiptDetail getGoodsReceiptDetail() { return goodsReceiptDetail; }
    public void setGoodsReceiptDetail(GoodsReceiptDetail goodsReceiptDetail) { this.goodsReceiptDetail = goodsReceiptDetail; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
