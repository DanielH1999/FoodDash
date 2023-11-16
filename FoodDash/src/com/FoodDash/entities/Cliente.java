package com.FoodDash.entities;


public class Cliente {
    private int id;
    private String nombre;
    private int telefono;
    private String direccion;

    public Cliente() {}

    public Cliente(int id, String nombre, int telefono, String direccion) {
        setId(id);
        setNombre(nombre);
        setTelefono(telefono);
        setDireccion(direccion);
    }
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
}
