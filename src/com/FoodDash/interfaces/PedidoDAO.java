/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.FoodDash.interfaces;

import com.FoodDash.entities.Cliente;
import com.FoodDash.entities.Pedido;
import com.FoodDash.entities.Restaurant;
import java.util.List;

/**
 *
 * @author d3m0n10
 */
public interface PedidoDAO {
	void ingresarPedido(Pedido pedido);
	void actualizarPedido(Pedido pedido);
	List<Cliente> getClientes();
	List<Restaurant> getRestaurants();
}
