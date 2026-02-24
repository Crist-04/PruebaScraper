package com.example.pruebascraper.DTO;

public class ProductoDTO {

    private String titulo;
    private Double precio;
    private String moneda;
    private String url;
    private String imagenUrl;
    private String vendedor;

    public ProductoDTO() {
    }

    public ProductoDTO(String titulo, Double precio, String moneda,
            String url, String imagenUrl, String vendedor) {
        this.titulo = titulo;
        this.precio = precio;
        this.moneda = moneda;
        this.url = url;
        this.imagenUrl = imagenUrl;
        this.vendedor = vendedor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

}
