package com.test.gateway.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "peripheral", schema = "public")
public class PeripheralEntity {
    private Long uid;
    private String vendor;
    private Timestamp createdAt;
    private String status;

    private GatewayEntity gateway;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "vendor", nullable = false)
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name="gateway_serial" , nullable=false)
    public GatewayEntity getGateway() {
        return gateway;
    }

    public void setGateway(GatewayEntity gateway) {
        this.gateway = gateway;
    }
}
