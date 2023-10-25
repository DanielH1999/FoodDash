package com.FoodDash.entities;

/**
 *
 * @author AULA7-MAQUINA9
 */
public class Envio {
    
    private int id_envio;
    private int id_cliente;
    private int id_pedido;
    private int id_restaurant;
    private int direccion;
    private int medio_pago;
    private int precio_envio;
    private int estado;

    public Envio() {
    }

    public Envio(int id_envio, int id_cliente, int id_pedido, int id_restaurant, int direccion, int medio_pago, 
            int precio_envio, int estado) {
        this.setId_envio(id_envio);
        this.setId_cliente(id_cliente);
        this.setId_pedido(id_pedido);
        this.setId_restaurant(id_restaurant);
        this.setDireccion(direccion);
        this.setMedio_pago(medio_pago);
        this.setPrecio_envio(precio_envio);
        this.setEstado(estado);
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(int medio_pago) {
        this.medio_pago = medio_pago;
    }

    public int getPrecio_envio() {
        return precio_envio;
    }

    public void setPrecio_envio(int precio_envio) {
        this.precio_envio = precio_envio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Envio{" + "id_envio=" + id_envio + ", id_cliente=" + id_cliente + ", id_pedido=" + id_pedido + 
                ", id_restaurant=" + id_restaurant + ", direccion=" + direccion + ", medio_pago=" + medio_pago +
                ", precio_envio=" + precio_envio + ", estado=" + estado + '}';
    }
    
    
}
