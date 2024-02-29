package com.example.demoJavaCoderHouse.controllers;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJavaCoderHouse.models.Cliente;
import com.example.demoJavaCoderHouse.models.ClienteDTO;
import com.example.demoJavaCoderHouse.models.producto;
import com.example.demoJavaCoderHouse.repository.ClienteRepository;
import com.example.demoJavaCoderHouse.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    

    @Operation(summary = "Lista clientes", description = "Lista todos los clientes existentes en la BBDD")
    @GetMapping("/clientes")
    public Set<ClienteDTO> getClientes() {
        return clienteService.clientesDto();

    }

    @Operation(summary = "Agrega un Cliente", description = "Agrega un cliente a la BBDD", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = ClienteDTO.class))))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa el cliente se agrego correctamente"),
            @ApiResponse(responseCode = "409", description = "Erorr! la operacion no se pudo crear " +
                    "el registro en la BBDD", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDTO.class)) }) })

    @PostMapping("cliente/alta")
    public String post(@RequestBody Cliente cliente) {
        clienteService.GuardarClientes(cliente);
        return "cliente guardado correctamente";
    }

    @PutMapping("cliente/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Cliente cliente) {
      clienteService.ActualizarCliente(id, cliente);
      return "El cliente se actualizo correctamente";
    }

    @DeleteMapping("cliente/eliminar/{id}")
    public String delete(@PathVariable Long id){
        clienteService.EliminarCliente(id);
        return "El cliente se elimino con exito";
    }

}