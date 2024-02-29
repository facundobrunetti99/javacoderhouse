package com.example.demoJavaCoderHouse.models;

import io.swagger.v3.oas.annotations.media.Schema;

public class ProductoDTO {
    
    
    @Schema(description = "Nombre del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "Microondas")
    private String productonombre;
    @Schema(description = "Codigo del Producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "12574963")
    private String productoid;
    @Schema(description = "Precio del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "$1550")
    private float priceproduct;
    public String getProductonombre() {
        return productonombre;
    }
    public void setProductonombre(String productonombre) {
        this.productonombre = productonombre;
    }
    public String getProductoid() {
        return productoid;
    }
    public void setProductoid(String productoid) {
        this.productoid = productoid;
    }
    public float getPriceproduct() {
        return priceproduct;
    }
    public void setPriceproduct(float priceproduct) {
        this.priceproduct = priceproduct;
    }
    public ProductoDTO() {
    }
    public ProductoDTO(String productonombre, String productoid, float priceproduct) {
        this.productonombre = productonombre;
        this.productoid = productoid;
        this.priceproduct = priceproduct;
    }

    
}
