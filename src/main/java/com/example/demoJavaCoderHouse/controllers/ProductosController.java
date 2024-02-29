package com.example.demoJavaCoderHouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJavaCoderHouse.models.Cliente;
import com.example.demoJavaCoderHouse.models.producto;
import com.example.demoJavaCoderHouse.repository.ProductoRepository;

@RestController
public class ProductosController {
        @Autowired
        private ProductoRepository prodrepo;


        
    @GetMapping("/productos")
    public List<producto> getClientes(){
        return  prodrepo.findAll();
    }

    @PostMapping("producto/alta")
    public String post(@RequestBody producto prod){
        prodrepo.save(prod);
        return "Alta realizada";
    }

    @PutMapping("producto/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody producto prod) {
       producto updateProducto= prodrepo.findById(id).get();
    updateProducto.setCantproduct(prod.getCantproduct());
    updateProducto.setNameproduct(prod.getNameproduct());
    updateProducto.setPriceproduct(prod.getPriceproduct());
        return "Se realizo el cambio";
    }


}
