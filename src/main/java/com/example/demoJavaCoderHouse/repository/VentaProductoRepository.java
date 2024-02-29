package com.example.demoJavaCoderHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJavaCoderHouse.models.VentaProducto;

@Repository
public interface VentaProductoRepository extends JpaRepository<VentaProducto, Long> {

}
