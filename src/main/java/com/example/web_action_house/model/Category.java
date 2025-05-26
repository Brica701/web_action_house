package com.example.web_action_house.model;

public class Category {
        private int id;
        private String nombre;

        public Category() {}

        public Category(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
    }
