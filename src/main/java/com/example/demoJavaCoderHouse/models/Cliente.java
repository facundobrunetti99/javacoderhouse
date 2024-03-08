package com.example.demoJavaCoderHouse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Column(name = "id")
    @Schema(description = "id usuario autogestionado por la BBDD", requiredMode = Schema.RequiredMode.AUTO, example = "2")
    private Long id;

    @Column(name = "Nombre")
    @Schema(description = "Nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Facundo")
    private String clienteNombre;

    @Column(name = "Domicilio")
    private String clienteDomicilio;

    @Column(name = "Dni")
    @Schema(description = "Número de documento del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "27366988")
    private int clienteDni;

    @Schema(description = "Fecha de nacimiento", requiredMode = Schema.RequiredMode.REQUIRED, example = "13-05-1990")
    @Column(name = "FechaNac")
    private String FechaNac;
       
   @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private VentaProducto ventaProducto;
  

    public VentaProducto getVentaProducto() {
        return ventaProducto;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(int clienteDni) {
        this.clienteDni = clienteDni;
    }

    public Cliente(Long id, String clienteNombre, String clienteDomicilio, int clienteDni, String fechaNac,
            VentaProducto ventaProducto) {
        this.id = id;
        this.clienteNombre = clienteNombre;
        this.clienteDomicilio = clienteDomicilio;
        this.clienteDni = clienteDni;
        this.FechaNac = fechaNac;
        this.ventaProducto = ventaProducto;
    }

    public Cliente() {
    }
 

    public void setVentaProducto(VentaProducto ventaProducto) {
        this.ventaProducto = ventaProducto;
    }


}
