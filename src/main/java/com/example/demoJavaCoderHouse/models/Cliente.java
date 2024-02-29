package com.example.demoJavaCoderHouse.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;


@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteDni;

    @Column(name = "Nombre")
    private String clienteNombre;

    @Column(name = "Domicilio")
    private String clienteDomicilio;

    @Column(name = "FechaNac")
    private String FechaNac;

    @ManyToOne(fetch = FetchType.EAGER)
    private VentaProducto ventaProducto;

    public Long getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(Long clienteDni) {
        this.clienteDni = clienteDni;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteDomicilio() {
        return clienteDomicilio;
    }

    public void setClienteDomicilio(String clienteDomicilio) {
        this.clienteDomicilio = clienteDomicilio;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String fechaNac) {
        FechaNac = fechaNac;
    }

    public VentaProducto getVentaProducto() {
        return ventaProducto;
    }

    public void setVentaProducto(VentaProducto ventaProducto) {
        this.ventaProducto = ventaProducto;
    }

    public Cliente(Long clienteDni, String clienteNombre, String clienteDomicilio, String fechaNac,
            VentaProducto ventaProducto) {
        this.clienteDni = clienteDni;
        this.clienteNombre = clienteNombre;
        this.clienteDomicilio = clienteDomicilio;
        FechaNac = fechaNac;
        this.ventaProducto = ventaProducto;
    }

    public Cliente() {
    }
 

}
