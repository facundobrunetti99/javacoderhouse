package com.example.demoJavaCoderHouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJavaCoderHouse.models.VentaProducto;

import com.example.demoJavaCoderHouse.repository.VentaProductoRepository;

import io.micrometer.common.lang.NonNull;

@RestController
public class VentaProductoController {
    @Autowired
    private VentaProductoRepository   ventaprodrepo;

    @GetMapping("/ventas")
    public List<VentaProducto> getVentaProductos() {
        return ventaprodrepo.findAll();
    }

    @PostMapping("venta/alta")
    public String post(@RequestBody VentaProducto ventaprod) {
        ventaprodrepo.save(ventaprod);
        return "Alta realizada";
    }

}
