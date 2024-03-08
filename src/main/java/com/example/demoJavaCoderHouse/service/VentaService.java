package com.example.demoJavaCoderHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.example.demoJavaCoderHouse.models.Cliente;
import com.example.demoJavaCoderHouse.models.VentaProducto;
import com.example.demoJavaCoderHouse.models.producto;
import com.example.demoJavaCoderHouse.repository.VentaProductoRepository;

@Service
public class VentaService {
    @Autowired
    private VentaProductoRepository ventaprodRepo;
   

    public List<VentaProducto> ListaVenta() {
        List<VentaProducto> ventas = ventaprodRepo.findAll();
      
        for (VentaProducto venta : ventas) {
            venta.getProductos().size(); // Cargar productos asociados
            venta.getClientes().size(); // Cargar clientes asociados
        }
        return ventas;
    }






    public void CargarVenta(VentaProducto ventaProducto) {
        ventaprodRepo.save(ventaProducto);
    }

    public void EliminarVenta(Long id) {
        Optional<VentaProducto> ventaProdBD = ventaprodRepo.findById(id);

        if (ventaProdBD != null) {
            VentaProducto ventaProductoEliminar = ventaProdBD.get();
            ventaprodRepo.delete(ventaProductoEliminar);
        }
    }

    public void ActualizarVenta(Long id, VentaProducto ventaProd) {
        Optional<VentaProducto> ventaProdBd = ventaprodRepo.findById(id);
        if (ventaProdBd != null) {
            VentaProducto ventaProductoActualizar = ventaProdBd.get();
            ventaProductoActualizar.setVentaId(ventaProd.getVentaId());
            ventaProductoActualizar.setVentafecha(ventaProd.getVentafecha());
            ventaProductoActualizar.setVentamontoTotal(ventaProd.getVentamontoTotal());
        }
    }

}
