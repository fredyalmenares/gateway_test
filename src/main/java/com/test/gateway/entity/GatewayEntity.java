package com.test.gateway.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "gateway", schema = "public")
@DynamicInsert
@DynamicUpdate
public class GatewayEntity {
    private String serial;
    private String name;
    private String address;

    private Collection<PeripheralEntity> peripherals;

    @Id
    @Column(name = "serial", nullable = false)
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy="uid", targetEntity = PeripheralEntity.class)
    public Collection<PeripheralEntity> getPeripherals() {
        return peripherals;
    }

    public void setPeripherals(Collection<PeripheralEntity> peripherals) {
        this.peripherals = peripherals;
    }
}
