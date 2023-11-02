package com.FoodDash.test;

import com.FoodDash.dao.RestaurantDAOImpl;
import com.FoodDash.entities.Pedido;

public class RestaurantDAOImplTest {
    
    public static void main(String[] args) {
        RestaurantDAOImpl rdao = new RestaurantDAOImpl();
        Pedido pedido = new Pedido();
        
        rdao.aceptar_pedido(pedido);
    }
}
