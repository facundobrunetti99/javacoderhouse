package com.example.demoJavaCoderHouse.models;
import io.swagger.v3.oas.annotations.media.Schema;


//Establezco Entidad para la tabla Clientes

public class ClienteDTO {
    @Schema(description = "Nombre del Cliente",requiredMode = Schema.RequiredMode.REQUIRED, example = "Facundo")
    private String nombre;

    @Schema(description = "Apellido del Cliente",requiredMode = Schema.RequiredMode.REQUIRED, example = "Brunetti")
    private String apellido;


    @Schema(description = "Número de documento del Cliente", requiredMode = Schema.RequiredMode.REQUIRED,example = "1235689")
    private String dni;

    public ClienteDTO(){}
    public ClienteDTO(String nom, String apel, String dni){
        this.nombre = nom;
        this.apellido = apel;
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    

}
