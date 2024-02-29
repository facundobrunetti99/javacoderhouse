package com.example.demoJavaCoderHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJavaCoderHouse.models.producto;

@Repository
public interface ProductoRepository extends JpaRepository<producto, Long> {

}
