package com.FoodDash.test;

import com.FoodDash.dao.ClienteDAOlmpl;
import com.FoodDash.entities.Cliente;
import com.FoodDash.entities.Pedido;
import com.FoodDash.entities.Restaurant;
import java.sql.SQLException;
import java.util.Arrays;


public class ClienteDAOlmplTest {
    public static void main(String[] args) throws SQLException {
        Cliente cliente = new Cliente(44983341, "Gilberto Funes", 1100293929, "Rivadavia 402");
        
        Restaurant restaurante = new Restaurant(2, /*1, */1, "Hamburgueseria", 1145654777);
        
        Pedido pedido = new Pedido();
                pedido.setId_pedido(0);
                pedido.setId_cliente(44983345);
                pedido.setId_restaurant(230944);
                pedido.setProductos(Arrays.asList("Hamburguesa triple con papas"));
                pedido.setCantidades(Arrays.asList("4"));
                pedido.setSuma_precio(160000);
                pedido.setTiempo_preparacion(15);
                pedido.setEstado(1);

         ClienteDAOlmpl clienteDAOlmpl = new ClienteDAOlmpl();
         
         clienteDAOlmpl.realizarPedido(cliente,pedido, restaurante);
         
         System.out.println(pedido.toString());
    }
}
