package com.example.demoJavaCoderHouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJavaCoderHouse.models.VentaProducto;

import com.example.demoJavaCoderHouse.service.VentaService;

@RestController
public class VentaProductoController {
    @Autowired
    private VentaService ventaservice;

    @GetMapping("/ventas")
    public List<VentaProducto> getVentaProductos() {
        return ventaservice.ListaVenta();
    }

    @PostMapping("venta/alta")
    public String post(@RequestBody VentaProducto ventaprod) {
        ventaservice.CargarVenta(ventaprod);
        return "Alta realizada";
    }

    @DeleteMapping("venta/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        ventaservice.EliminarVenta(id);

        return "Venta eliminada";
    }

    @PutMapping("venta/actualizar/{id}")
    public String update(@PathVariable Long id, @RequestBody VentaProducto ventaprod) {
        ventaservice.ActualizarVenta(id, ventaprod);
        return "Actualizacion confirmada";
    }
}
