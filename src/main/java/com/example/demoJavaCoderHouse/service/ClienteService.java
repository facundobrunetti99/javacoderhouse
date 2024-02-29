package com.example.demoJavaCoderHouse.service;

import java.util.Set;
import com.example.demoJavaCoderHouse.models.ClienteDTO;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.example.demoJavaCoderHouse.models.Cliente;
import com.example.demoJavaCoderHouse.models.producto;
import com.example.demoJavaCoderHouse.repository.ClienteRepository;
import com.example.demoJavaCoderHouse.repository.ProductoRepository;

public class ClienteService {
    @Autowired
    private ClienteRepository ClienteRepository;
    //En este punto lo que voy a hacer es listar los clientes, en este casa
    //ClienteRepository se encarga de conectarse con la bd y trae los datos
    //entonces debo parti y utilizar esto

    /*Ahora crearemos un metodo para mostrar los clientes */
   public Set<ClienteDTO> clientesDto(){
        Set<ClienteDTO>clients=new HashSet<>(); //creo un conjunto de clientes
        for(Cliente cliente:ClienteRepository.findAll()){ //En ese punto itero sobre el repositorio de los clientes
            ClienteDTO clientedto=new ClienteDTO();//luego creo un cliente DTO que es el que voy a mostrar
            clientedto.setNombre(cliente.getClienteNombre());//en cada argunmento de clienteDTO le paso el argumento del cliente que quier mostrar
            clientedto.setDni(cliente.getClienteDni());
            clientedto.setDomicilio(cliente.getClienteDomicilio());
            clients.add(clientedto);
        }
        return clients;//retorno el conjunto cliente dto
    }


    /*Ahora vamos con almacenar un cliente */
    /*En este punto tenemos que almacenar un cliente en la BDD 
     * hay que hacer uso del repositorio ya que este se conecta 
     * y de los atributos del cliente
     */
    public void GuardarClientes(Cliente cliente){
        ClienteRepository.save(cliente);
    }
    /*Ahora vamos a Actualizar un cliente
     * En este caso tambien vamos a hacer uso del repositorio para conectar con la BDD
     * Lo primero que debemos tener en cuenta es que al actualizar tenemos que buscar el 
     * cliente por el id y partir desde ahi
     */
    public void ActualizarCliente(Long id, Cliente cliente){
        Optional<Cliente>clienteBD=ClienteRepository.findById(id);//este metodo me sirve para                                                          
        if(clienteBD!=null){                          //buscar el cliente por ID en la BDD si existe entro 
            Cliente clienteActulizar =clienteBD.get();//y aca lo que hago es que creo un cliente para actualizar y lo igualo al clieBD.get()
            clienteActulizar.setClienteNombre(cliente.getClienteNombre());//Que este mismo me devuelve el cliente en especifico para actulizar
            clienteActulizar.setClienteDni(cliente.getClienteDni());
            clienteActulizar.setClienteDomicilio(cliente.getClienteDomicilio());
            clienteActulizar.setFechaNac(cliente.getFechaNac());
                                                  
        }
    }

    //Ahora elimino el cliente
    public void EliminarCliente(Long Id){
        Optional<Cliente>clienteBd=ClienteRepository.findById(Id);
        if(clienteBd!=null){
            Cliente clienteEliminar=clienteBd.get();
            ClienteRepository.delete(clienteEliminar);
        }
    }


   
}
