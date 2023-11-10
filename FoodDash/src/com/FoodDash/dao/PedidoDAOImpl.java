package com.FoodDash.dao;

import com.FoodDash.entities.Cliente;
import com.FoodDash.entities.Restaurant;
import com.FoodDash.interfaces.PedidoDAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.FoodDash.connector.Connector;
import com.FoodDash.entities.Pedido;


public class PedidoDAOImpl implements PedidoDAO{

    public List<Restaurant> getAllRestaurants(Pedido pedido) throws SQLException
    {
        Connection conexion = (Connection) Connector.getConnection();
        
        // tomar todos los restaurants
            List<Restaurant> restaurants = new ArrayList<>();
            
            PreparedStatement statement = conexion.prepareStatement("select * from restaurant");
            ResultSet Database = statement.executeQuery();
            
            while (Database.next())
            {
                Restaurant restaurant = new Restaurant();
                restaurant.setId_restaurant(Database.getInt("id_restaurant"));
                restaurant.setNombre(Database.getString("nombre"));
                restaurant.setTelefono(Database.getInt("telefono"));
                restaurants.add(restaurant);
            }
            pedido.setRestaurants(restaurants);
            //pasarlos a pedido para enlazar
            
    }
    
    public void getAllClients(Pedido pedido)
    {
        throw new UnsupportedOperationException("No implementado");
        List<Cliente> clientes = new ArrayList<>();
    }
    
    @Override
    public void recibir_pago() {
        throw new UnsupportedOperationException("No implementado");
    }
    
}
