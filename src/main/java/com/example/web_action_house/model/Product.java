package com.example.web_action_house.model;

import java.time.LocalDate;

public class Product {
    private int id;
    private String nombre;
    private String descripcion;
    private String urlImagen;
    private double pujaInicial;
    private double pujaActual;
    private LocalDate fechaFinSubasta;

    private Category categoria;
    private User usuarioSubasta; // Cliente que subasta el producto

    public Product() {}

    public Product(int id, String nombre, String descripcion, String urlImagen, double pujaInicial,
                   double pujaActual, LocalDate fechaFinSubasta, Category categoria, User usuarioSubasta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.pujaInicial = pujaInicial;
        this.pujaActual = pujaActual;
        this.fechaFinSubasta = fechaFinSubasta;
        this.categoria = categoria;
        this.usuarioSubasta = usuarioSubasta;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUrlImagen() { return urlImagen; }
    public void setUrlImagen(String urlImagen) { this.urlImagen = urlImagen; }

    public double getPujaInicial() { return pujaInicial; }
    public void setPujaInicial(double pujaInicial) { this.pujaInicial = pujaInicial; }

    public double getPujaActual() { return pujaActual; }
    public void setPujaActual(double pujaActual) { this.pujaActual = pujaActual; }

    public LocalDate getFechaFinSubasta() { return fechaFinSubasta; }
    public void setFechaFinSubasta(LocalDate fechaFinSubasta) { this.fechaFinSubasta = fechaFinSubasta; }

    public Category getCategoria() { return categoria; }
    public void setCategoria(Category categoria) { this.categoria = categoria; }

    public User getUsuarioSubasta() { return usuarioSubasta; }
    public void setUsuarioSubasta(User usuarioSubasta) { this.usuarioSubasta = usuarioSubasta; }
}
