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
    void aceptar_pedido(Pedido pedido);
    void rechazar_pedido(Pedido pedido);
    void finalizar_pedido(Pedido pedido);
}
