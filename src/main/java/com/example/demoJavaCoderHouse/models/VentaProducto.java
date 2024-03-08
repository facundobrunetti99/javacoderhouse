package com.example.demoJavaCoderHouse.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventaProducto")
public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ventaId;
    @Column(name = "ventamontoTotal")
    private float ventamontoTotal;
    @Column(name = "ventafecha")
    private String ventafecha;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ventaProducto")

    private Set<producto> productos = new HashSet<>();
 
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ventaProducto")
   
    private Set<Cliente> clientes = new HashSet<>();
  

    public VentaProducto() {
    }

   

    public VentaProducto(Long ventaId, float ventamontoTotal, String ventafecha, Set<producto> productos,
            Set<Cliente> clientes) {
        this.ventaId = ventaId;
        this.ventamontoTotal = ventamontoTotal;
        this.ventafecha = ventafecha;
        this.productos = productos;
        this.clientes = clientes;
    }



    public Long getVentaId() {
        return ventaId;
    }

    public void setVentaId(Long ventaId) {
        this.ventaId = ventaId;
    }

    public float getVentamontoTotal() {
        return ventamontoTotal;
    }

    public void setVentamontoTotal(float ventamontoTotal) {
        this.ventamontoTotal = ventamontoTotal;
    }

    public String getVentafecha() {
        return ventafecha;
    }

    public void setVentafecha(String ventafecha) {
        this.ventafecha = ventafecha;
    }

    public Set<producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<producto> productos) {
        this.productos = productos;
    }

    
   
    public Set<Cliente> getClientes() {
        return clientes;
    }



    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

  
}
