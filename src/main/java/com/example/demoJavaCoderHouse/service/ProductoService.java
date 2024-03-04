package com.example.demoJavaCoderHouse.service;
import java.util.Set;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import com.example.demoJavaCoderHouse.models.ProductoDTO;
import com.example.demoJavaCoderHouse.models.producto;
import com.example.demoJavaCoderHouse.repository.ProductoRepository;

@Service
public class ProductoService {
        @Autowired
        private ProductoRepository productoRepository;


        
        //Mostrar lista de productos
        public Set<ProductoDTO> listaProductos(){
            Set<ProductoDTO>productosDTO=new HashSet<>();
            
            for(producto prod:productoRepository.findAll()){
                ProductoDTO prodDTOmostrar=new ProductoDTO();
                prodDTOmostrar.setPriceproduct(prod.getPriceproduct());
                prodDTOmostrar.setProductonombre(prod.getNameproduct());
                prodDTOmostrar.setProductoid(prod.getIdproduct());
                productosDTO.add(prodDTOmostrar);
            }
                return productosDTO;
        }

        //Cargar un nuevo producto
        public void CargarProducto(producto prod){
            productoRepository.save(prod);
        }

        //Actualizar un producto

        public void ActualizarProducto(Long id, producto producto){
            Optional<producto> productoBD=productoRepository.findById(id);
            if(productoBD!=null){
                producto productoActualizar=productoBD.get();
                productoActualizar.setNameproduct(producto.getNameproduct());
                productoActualizar.setPriceproduct(producto.getPriceproduct());
                productoActualizar.setCantproduct(producto.getCantproduct());
            }
        }

        public void EliminarProducto(Long id){
            Optional<producto>productoBD=productoRepository.findById(id);
            if(productoBD!=null){
                producto producto=productoBD.get();
                productoRepository.delete(producto);
            }
        }


}
