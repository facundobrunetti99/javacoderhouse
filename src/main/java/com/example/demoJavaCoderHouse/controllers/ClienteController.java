package com.example.demoJavaCoderHouse.controllers;

import java.util.List;
import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJavaCoderHouse.models.Cliente;
import com.example.demoJavaCoderHouse.repository.ClienteRepository;

@RestController
public class ClienteController   {

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return  clienteRepo.findAll();
    }

    @PostMapping("cliente/alta")
    public String post(@RequestBody Cliente cliente){
        clienteRepo.save(cliente);
        return "Alta realizada";
    }

    @PutMapping("cliente/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Cliente cliente) {
       Cliente updateCliente= clienteRepo.findById(id).get();
       updateCliente.setClienteDomicilio(cliente.getClienteDomicilio());
       updateCliente.setClienteNombre(cliente.getClienteNombre());
       updateCliente.setFechaNac(cliente.getFechaNac());
        return "Se realizo el cambio";
    }






}