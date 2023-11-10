package com.FoodDash.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author d3m0n10
 */
public class Restaurant {
    private int id_restaurant;
    private int id_pedido;
    private int id_envio;
    private String nombre;
    private int telefono;
    private List<String> productos = new ArrayList<>();
    private List<String> cantidades = new ArrayList<>();
    
    public Restaurant(){}

    public Restaurant(int id_restaurant, int id_pedido, int id_envio, String nombre, int telefono) {
        this.setId_restaurant(id_restaurant);
        this.setId_pedido(id_pedido);
        this.setId_envio(id_envio);
        this.setNombre(nombre);
        this.setTelefono(telefono);
    }

    
    
    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }

    public List<String> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<String> cantidades) {
        this.cantidades = cantidades;
    }

//    @Override
//    public String toString() {
//        return "id_restaurant: "+id_restaurant+"\nid_pedido: "+id_pedido
//               +"\nid_envio: "+id_envio+"\nnombre: "+nombre+"\ntelefono: "
//               +telefono;
//    }
    
    @Override
    public String toString()
    {
        return nombre + ", " + telefono;
    }
}
