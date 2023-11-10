package com.FoodDash.dao;

import com.FoodDash.connector.*;
import com.FoodDash.entities.Cliente;
import com.FoodDash.entities.Pedido;
import com.FoodDash.entities.Restaurant;
import com.FoodDash.interfaces.RestaurantDAO;
import java.util.Arrays;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RestaurantDAOImpl implements RestaurantDAO {
    private final int EN_PROCESO = 0;
    private final int LISTO = 1;
    private final int ENVIADO = 2;
    private final int RECHAZADO = 4;
    private final int tiempo_preparacion = 15;

    @Override
    public void aceptar_pedido(Pedido pedido)
    {
        int id_restaurant = pedido.getId_restaurant();
        int id_cliente = pedido.getId_cliente();
        
        try {
            Connection conexion = (Connection) Connector.getConnection();
            PreparedStatement statement = null;
            
            //establecer estado del pedido como "en proceso"
            cambiarEstado(id_restaurant, id_cliente, EN_PROCESO);
            
            String query = "select * from pedido where id_restaurant = ? and id_cliente =?";
            statement = conexion.prepareStatement(query);
            statement.setInt(1, id_restaurant);
            statement.setInt(2, id_cliente);
            ResultSet Database = statement.executeQuery();
            
            //Inicializar [restaurant]
            Restaurant restaurant = new Restaurant();
            
            if (Database.next())
            {
                //ingreso datos del restaurant desde la tabla pedido
                restaurant.setId_restaurant(Database.getInt("id_restaurant"));
                restaurant.setId_pedido(Database.getInt("id_pedido"));
                restaurant.setProductos(Arrays.asList(Database.getString("productos").split(", ")));
                restaurant.setCantidades(Arrays.asList(Database.getString("cantidades").split(",")));
                
            }
            
            query = "SELECT * FROM restaurant JOIN pedido ON restaurant.id_restaurant = pedido.id_restaurant WHERE pedido.id_cliente = ? AND pedido.id_restaurant = ?";
            statement = conexion.prepareStatement(query);
            statement.setInt(1, id_cliente);
            statement.setInt(2, id_restaurant);
            Database = statement.executeQuery();
            
            if (Database.next())
            {
                restaurant.setNombre(Database.getString("nombre"));
                restaurant.setTelefono(Database.getInt("telefono"));
            }
            
            //cerrar conexion
            conexion.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("pedido aceptado");
    }

    @Override
    public void rechazar_pedido(Pedido pedido)
    {
        try
        {
            cambiarEstado(pedido.getId_restaurant(), pedido.getId_cliente(), RECHAZADO);
            pedido.setEstado(RECHAZADO);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("pedido rechazado");
    }

    @Override
    public void finalizar_pedido(Pedido pedido)
    {
        try
        {
            //cambiar estado del pedido
            cambiarEstado(pedido.getId_restaurant(), pedido.getId_cliente(), LISTO);
            pedido.setEstado(LISTO);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("pedido pendiente para envio");
        //enviar pedido
        gatillarEnvio(pedido);
    }
    
    //cambiar el estado del pedido a uno predefinido
    public String cambiarEstado(int id_restaurant, int id_cliente, int estado)
            throws SQLException
    {
        String error = null;
        Connection conexion = Connector.getConnection();
        String[] estadosPosibles = {"en proceso", "listo", "enviado", "finalizado", "rechazado"};
        
        try
        {
            conexion = (Connection) Connector.getConnection();
            PreparedStatement statement = null;
            
            //establecer estado del pedido como "en proceso"
            String query = "update pedido set estado = '"+estadosPosibles[estado]+"' where id_restaurant = ? and id_cliente = ?";
            
            statement = conexion.prepareStatement(query);
            statement.setInt(1, id_restaurant);
            statement.setInt(2, id_cliente);
            statement.execute();
        }
        catch (SQLException ex) {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            error = "SQL Exception";
        }
        catch (IndexOutOfBoundsException ex)
        {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE,"index out of bounds",ex);
            error = "Index out of bounds, enter a number between 0 and "+(estadosPosibles.length - 1);
        }
        finally
        {
            conexion.close();
            return error;
        }
    }
    
    public static List<Restaurant> getRestaurantList()
    {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        Restaurant aRestaurant = new Restaurant();
        Connection conexion = null;
        try
        {
           conexion = (Connection) Connector.getConnection();
            PreparedStatement statement = null;
            
            //establecer estado del pedido como "en proceso"
            String query = "select * from restaurant";
            
            statement = conexion.prepareStatement(query);
            ResultSet Database = statement.executeQuery();
            
            while (Database.next())
            {
                aRestaurant = new Restaurant();
                aRestaurant.setId_restaurant(Database.getInt("id_restaurant"));
                aRestaurant.setNombre(Database.getString("nombre"));
                aRestaurant.setTelefono(Database.getInt("telefono"));
                restaurants.add(aRestaurant);
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IndexOutOfBoundsException ex)
        {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE,"index out of bounds",ex);
        }
        finally
        {
            return restaurants;
        }
    }
    
    public String gatillarEnvio(Pedido pedido)
    {
        return null;
    }
}