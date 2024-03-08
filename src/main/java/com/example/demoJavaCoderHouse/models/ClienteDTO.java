package com.example.demoJavaCoderHouse.models;

import io.swagger.v3.oas.annotations.media.Schema;

//Establezco Entidad para la tabla Clientes

public class ClienteDTO {
    @Schema(description = "Nombre del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Facundo")
    private String nombre;
    @Schema(description = "Domicilio del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Calle 1234")
    private String domicilio;

    @Schema(description = "Número de documento del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1235689")
    private int dni;

    private VentaProducto ventaProducto;
    public ClienteDTO() {
    }

    
    public ClienteDTO(String nombre, String domicilio, int dni, VentaProducto ventaProducto) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.ventaProducto = ventaProducto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }


    public VentaProducto getVentaProducto() {
        return ventaProducto;
    }


    public void setVentaProducto(VentaProducto ventaProducto) {
        this.ventaProducto = ventaProducto;
    }

}
