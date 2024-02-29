package com.example.demoJavaCoderHouse.models;

import java.util.HashSet;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "ventaProducto")
    private Set<producto> productos = new HashSet<>();

    @OneToOne(mappedBy = "ventaProducto",cascade = CascadeType.ALL)
    private Cliente cliente;
 

}
