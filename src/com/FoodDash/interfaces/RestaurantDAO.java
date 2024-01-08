/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.FoodDash.interfaces;

import com.FoodDash.entities.Pedido;

/**
 *
 * @author d3m0n10
 */
public interface RestaurantDAO {
    void aceptarPedido(Pedido pedido);
    void rechazarPedido(Pedido pedido);
    void finalizarPedido(Pedido pedido);
}
