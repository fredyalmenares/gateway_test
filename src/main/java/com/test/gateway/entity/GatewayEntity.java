package com.test.gateway.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gateway", schema = "public")
@DynamicInsert
@DynamicUpdate
public class GatewayEntity {
    private String serial;
    private String name;
    private String address;

    private Set<PeripheralEntity> peripherals = new HashSet<>();

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy="gateway", targetEntity = PeripheralEntity.class, cascade = CascadeType.ALL)
    public Set<PeripheralEntity> getPeripherals() {
        return peripherals;
    }

    public void setPeripherals(Set<PeripheralEntity> peripherals) {
        this.peripherals = peripherals;
    }

    @Override
    public String toString() {
        return "GatewayEntity{" +
                "serial='" + serial + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", peripherals=" + peripherals +
                '}';
    }
}
