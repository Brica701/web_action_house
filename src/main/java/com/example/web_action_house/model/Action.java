package com.example.web_action_house.model;

import java.time.LocalDateTime;

public class Action {
    private int id;
    private Product producto;
    private double pujaActual;
    private User usuarioPujador; // Usuario que hizo la última puja
    private LocalDateTime fechaPuja;

    public Action() {}

    public Action(int id, Product producto, double pujaActual, User usuarioPujador, LocalDateTime fechaPuja) {
        this.id = id;
        this.producto = producto;
        this.pujaActual = pujaActual;
        this.usuarioPujador = usuarioPujador;
        this.fechaPuja = fechaPuja;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Product getProducto() { return producto; }
    public void setProducto(Product producto) { this.producto = producto; }

    public double getPujaActual() { return pujaActual; }
    public void setPujaActual(double pujaActual) { this.pujaActual = pujaActual; }

    public User getUsuarioPujador() { return usuarioPujador; }
    public void setUsuarioPujador(User usuarioPujador) { this.usuarioPujador = usuarioPujador; }

    public LocalDateTime getFechaPuja() { return fechaPuja; }
    public void setFechaPuja(LocalDateTime fechaPuja) { this.fechaPuja = fechaPuja; }
}
