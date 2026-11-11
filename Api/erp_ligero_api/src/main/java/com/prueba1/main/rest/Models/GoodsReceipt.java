package com.prueba1.main.rest.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "goods_receipts")
public class GoodsReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private CustomerOrder order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "received_by", nullable = false)
    private User receivedBy;

    @Column(name = "receipt_date", nullable = false)
    private LocalDateTime receiptDate;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoodsReceiptDetail> details = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        if (this.receiptDate == null) this.receiptDate = LocalDateTime.now();
    }

    public GoodsReceipt() {}

    public void addDetail(GoodsReceiptDetail detail) {
        details.add(detail);
        detail.setReceipt(this);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public CustomerOrder getOrder() { return order; }
    public void setOrder(CustomerOrder order) { this.order = order; }
    public User getReceivedBy() { return receivedBy; }
    public void setReceivedBy(User receivedBy) { this.receivedBy = receivedBy; }
    public LocalDateTime getReceiptDate() { return receiptDate; }
    public void setReceiptDate(LocalDateTime receiptDate) { this.receiptDate = receiptDate; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public List<GoodsReceiptDetail> getDetails() { return details; }
    public void setDetails(List<GoodsReceiptDetail> details) { this.details = details; }
}
