package com.example.demoJavaCoderHouse.service;

import java.util.Set;
import com.example.demoJavaCoderHouse.models.ClienteDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import java.util.Optional;

import com.example.demoJavaCoderHouse.models.Cliente;

import com.example.demoJavaCoderHouse.repository.ClienteRepository;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository ClienteRepository;

    public Set<ClienteDTO> clientesDto() {
        Set<ClienteDTO> clients = new HashSet<>();
        for (Cliente cliente : ClienteRepository.findAll()) {
            ClienteDTO clientedto = new ClienteDTO();
            clientedto.setNombre(cliente.getClienteNombre());
            clientedto.setDni(cliente.getClienteDni());
            clientedto.setDomicilio(cliente.getClienteDomicilio());
            clientedto.setVentaProducto(cliente.getVentaProducto());
            clients.add(clientedto);
        }
        return clients;
    }

    public void GuardarClientes(Cliente cliente) {
        ClienteRepository.save(cliente);
    }

    public void ActualizarCliente(Long id, Cliente cliente) {
        Optional<Cliente> clienteBD = ClienteRepository.findById(id);
        if (clienteBD != null) {
            Cliente clienteActulizar = clienteBD.get();
            clienteActulizar.setClienteNombre(cliente.getClienteNombre());
            clienteActulizar.setClienteDni(cliente.getClienteDni());
            clienteActulizar.setClienteDomicilio(cliente.getClienteDomicilio());
            clienteActulizar.setFechaNac(cliente.getFechaNac());

        }
    }

    public void EliminarCliente(Long Id) {
        Optional<Cliente> clienteBd = ClienteRepository.findById(Id);
        if (clienteBd != null) {
            Cliente clienteEliminar = clienteBd.get();
            ClienteRepository.delete(clienteEliminar);
        }
    }

}
