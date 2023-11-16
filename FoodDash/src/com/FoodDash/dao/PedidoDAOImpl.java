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

    public static List<Restaurant> getAllRestaurants(Pedido pedido) throws SQLException
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
            //pasarlos a pedido para enlazar
            conexion.close();
            return restaurants;
    }
    
    public static List<Cliente> getAllClients(Pedido pedido) throws SQLException
    {
        Connection conexion = (Connection) Connector.getConnection();
        
        List<Cliente> clientes = new ArrayList<>();
        
        PreparedStatement statement = conexion.prepareStatement("select * from cliente");
        ResultSet Database = statement.executeQuery();
        
        while (Database.next())
        {
            Cliente cliente = new Cliente();
            cliente.setId(Database.getInt("id_cliente"));
            cliente.setNombre(Database.getString("nombre"));
            cliente.setDireccion(Database.getString("direccion"));
            cliente.setTelefono(Database.getInt("telefono"));
            clientes.add(cliente);
        }
        conexion.close();
        return clientes;
    }
    
    @Override
    public void recibir_pago() {
        throw new UnsupportedOperationException("No implementado");
        //cambiar el estado
    }
    
}
