package com.FoodDash.test;

import com.FoodDash.dao.RestaurantDAOImpl;
import com.FoodDash.entities.Pedido;
import java.util.Arrays;


public class RestaurantDAOImplTest {
    
    public static void main(String[] args) {
        RestaurantDAOImpl rdao = new RestaurantDAOImpl();
        
        Pedido pedido = new Pedido();
                pedido.setId_pedido(0);
                pedido.setId_cliente(11111111);
                pedido.setId_restaurant(1);
                pedido.setProductos(Arrays.asList("Hamburguesa triple con papas"));
                pedido.setCantidades(Arrays.asList("4"));
                pedido.setSuma_precio(160000);
                pedido.setTiempo_preparacion(15);
                pedido.setEstado(1);
        
        rdao.rechazarPedido(pedido);
        rdao.aceptarPedido(pedido);
    }
}
