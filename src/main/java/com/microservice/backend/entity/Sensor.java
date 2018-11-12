package com.microservice.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String location;
    private String factory;
    private Date install_time;
    private Date produce_date;
    private Date maintenance_time;
    private Long status;

    @ManyToOne
    @JoinColumn(name="gate_id")
    private Gateway gateway;

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    public Sensor() {
    }

    public Sensor(String description, String location, String factory, Date install_time, Date produce_date, Date maintenance_time, Long status, Gateway gateway) {
        this.description = description;
        this.location = location;
        this.factory = factory;
        this.install_time = install_time;
        this.produce_date = produce_date;
        this.maintenance_time = maintenance_time;
        this.status = status;
        this.gateway = gateway;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public Date getInstall_time() {
        return install_time;
    }

    public void setInstall_time(Date install_time) {
        this.install_time = install_time;
    }

    public Date getProduce_date() {
        return produce_date;
    }

    public void setProduce_date(Date produce_date) {
        this.produce_date = produce_date;
    }

    public Date getMaintenance_time() {
        return maintenance_time;
    }

    public void setMaintenance_time(Date maintenance_time) {
        this.maintenance_time = maintenance_time;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Sensor:"+this.description+" "+this.location;
    }
}
