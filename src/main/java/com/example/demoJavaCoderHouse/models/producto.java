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
@Table(name = "producto")
public class producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
     @Schema(description = "Codigo del Producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "12574963")
    private Long Idproduct;

    @Column(name = "nameproduct")
    @Schema(description = "Nombre del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "Microondas")
    private String nameproduct;

    @Column(name = "priceproduct")
    @Schema(description = "Precio del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "$1550")
    private float priceproduct;
    @Column(name = "cantproduct")
    private int cantproduct;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private VentaProducto ventaProducto;

  
    public int getCantproduct() {
        return cantproduct;
    }

    public Long getIdproduct() {
        return Idproduct;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public float getPriceproduct() {
        return priceproduct;
    }

    public void setCantproduct(int cantproduct) {
        this.cantproduct = cantproduct;
    }

    public void setIdproduct(Long idproduct) {
        Idproduct = idproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public void setPriceproduct(float priceproduct) {
        this.priceproduct = priceproduct;
    }

    public VentaProducto getVentaProducto() {
        return ventaProducto;
    }

    public void setVentaProducto(VentaProducto ventaProducto) {
        this.ventaProducto = ventaProducto;
    }

    public producto(Long idproduct, String nameproduct, float priceproduct, int cantproduct,
            VentaProducto ventaProducto) {
        Idproduct = idproduct;
        this.nameproduct = nameproduct;
        this.priceproduct = priceproduct;
        this.cantproduct = cantproduct;
        this.ventaProducto = ventaProducto;
    }

    public producto() {
    }

    
}
