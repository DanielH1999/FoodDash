package com.FoodDash.entities;

/**
 *
 * @author AULA7-MAQUINA9
 */
public class Pedido {
    private int id_pedido;
    private int id_cliente;
    private int id_restaurant;
    private int producto;
    private int cantidades;
    private int suma_precio;
    private int tiempo_preparacion;
    private int estado;

    public Pedido() {
    }

    public Pedido(int id_pedido, int id_cliente, int id_restaurant, int producto, int cantidades, int suma_precio, int tiempo_preparacion, int estado) {
        this.setId_pedido(id_pedido);
        this.setId_cliente(id_cliente);
        this.setId_restaurant(id_restaurant);
        this.setProducto(producto);
        this.setCantidades(cantidades);
        this.setSuma_precio(suma_precio);
        this.setTiempo_preparacion(tiempo_preparacion);
        this.setEstado(estado);
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getCantidades() {
        return cantidades;
    }

    public void setCantidades(int cantidades) {
        this.cantidades = cantidades;
    }

    public int getSuma_precio() {
        return suma_precio;
    }

    public void setSuma_precio(int suma_precio) {
        this.suma_precio = suma_precio;
    }

    public int getTiempo_preparacion() {
        return tiempo_preparacion;
    }

    public void setTiempo_preparacion(int tiempo_preparacion) {
        this.tiempo_preparacion = tiempo_preparacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", id_cliente=" + id_cliente + ", id_restaurant=" +
                id_restaurant + ", producto=" + producto + ", cantidades=" + cantidades + ", suma_precio=" +
                suma_precio + ", tiempo_preparacion=" + tiempo_preparacion + ", estado=" + estado + '}';
    }
    
    
}
