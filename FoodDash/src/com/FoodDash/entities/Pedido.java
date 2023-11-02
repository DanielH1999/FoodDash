package com.FoodDash.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AULA7-MAQUINA9
 */
public final class Pedido {
    private int id_pedido;//                                                    identificador del pedido | numerico
    private int id_cliente;//                                                   identificador del cliente | DNI
    private int id_restaurant;//                                                identificador del restaurant | numerico
    private List<String> productos = new ArrayList<>();//                       lista de productos que el cliente selecciono | ArrayList String
    private List<String> cantidades = new ArrayList<>();//                      lista de cantidades de cada producto que el cliente selecciono | ArrayList String representa una cantidad del producto de "productos" que comparte indice                  
    private float suma_precio;//                                                la sumatoria de los precios de los productos y el envio | numerico
    private int tiempo_preparacion;//                                           cantidad de minutos estimados para la preparacion de un pedido | numerico
    private int estado;//                                                       estado de preparacion del pedido () | numerico {0 al 3} {"en proceso", "enviado", "entregado", "finalizado"}

    public Pedido() {
    }

    public Pedido(int id_pedido, int id_cliente, int id_restaurant, ArrayList productos, ArrayList cantidades, int suma_precio, int tiempo_preparacion, int estado) {
        this.setId_pedido(id_pedido);
        this.setId_cliente(id_cliente);
        this.setId_restaurant(id_restaurant);
        this.setProductos(productos);
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

    public List getProducto() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }

    public List getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<String> cantidades) {
        this.cantidades = cantidades;
    }
    
    public void addProducto(String producto)
    {
        this.productos.add(producto);
    }
    
    public void addCantidad(String cantidad)
    {
        this.cantidades.add(cantidad);
    }

    public float getSuma_precio() {
        return suma_precio;
    }

    public void setSuma_precio(float suma_precio) {
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
                id_restaurant + ", productos=" + productos + ", cantidades=" + cantidades + ", suma_precio=" +
                suma_precio + ", tiempo_preparacion=" + tiempo_preparacion + ", estado=" + estado + '}';
    }
    
    
}
