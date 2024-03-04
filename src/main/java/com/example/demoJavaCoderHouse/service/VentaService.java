package com.example.demoJavaCoderHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demoJavaCoderHouse.models.VentaProducto;
import com.example.demoJavaCoderHouse.repository.VentaProductoRepository;

@Service
public class VentaService {
        @Autowired
        private VentaProductoRepository ventaprodRepo;


        public List<VentaProducto>ListaVenta(){
            return ventaprodRepo.findAll();

        }

        public void CargarVenta(VentaProducto ventaProducto){
            ventaprodRepo.save(ventaProducto);
        }


        public void EliminarVenta(Long id){
            Optional<VentaProducto> ventaProdBD=ventaprodRepo.findById(id);

            if(ventaProdBD!=null){
                VentaProducto ventaProductoEliminar=ventaProdBD.get();
                ventaprodRepo.delete(ventaProductoEliminar);
            }
        }

        public void ActualizarVenta(Long id, VentaProducto ventaProd){
            Optional<VentaProducto> ventaProdBd=ventaprodRepo.findById(id);
            if(ventaProdBd!=null){
                VentaProducto ventaProductoActualizar=ventaProdBd.get();
                ventaProductoActualizar.setVentaId(ventaProd.getVentaId());
                ventaProductoActualizar.setVentafecha(ventaProd.getVentafecha());
                ventaProductoActualizar.setVentamontoTotal(ventaProd.getVentamontoTotal());
            }
        }






}
