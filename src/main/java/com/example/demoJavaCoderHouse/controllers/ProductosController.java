package com.example.demoJavaCoderHouse.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJavaCoderHouse.models.ProductoDTO;
import com.example.demoJavaCoderHouse.models.producto;
import com.example.demoJavaCoderHouse.service.ProductoService;

@RestController
public class ProductosController {
    @Autowired
    private ProductoService prodService;

    @GetMapping("/productos")
    public Set<ProductoDTO> getClientes() {
        return prodService.listaProductos();
    }

    @PostMapping("producto/alta")
    public String post(@RequestBody producto prod) {
        prodService.CargarProducto(prod);
        return "Alta realizada";
    }

    @PutMapping("producto/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody producto prod) {
        prodService.ActualizarProducto(id, prod);
        return "Se realizo el cambio";
    }

    @DeleteMapping("producto/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        prodService.EliminarProducto(id);
        return "El producto se elimino correctamente";
    }
}
