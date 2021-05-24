package com.test.gateway.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "peripheral", schema = "public")
@DynamicInsert
public class PeripheralEntity  implements Serializable {
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
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
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

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name="gateway_serial" )
    @JsonIgnore
    public GatewayEntity getGateway() {
        return gateway;
    }

    public void setGateway(GatewayEntity gateway) {
        this.gateway = gateway;
    }

    @PrePersist
    public void onPrePersist() {
        setCreatedAt(Timestamp.from(Instant.now()));
    }

    @Override
    public String toString() {
        return "PeripheralEntity{" +
                "uid=" + uid +
                ", vendor='" + vendor + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", gateway_serial='" + (gateway != null ? gateway.getSerial() : "null") + '\'' +
                '}';
    }
}
