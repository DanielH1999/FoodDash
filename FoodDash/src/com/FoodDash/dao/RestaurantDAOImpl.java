package com.FoodDash.dao;

import com.FoodDash.connector.*;
import com.FoodDash.entities.Pedido;
import com.FoodDash.entities.Restaurant;
import com.FoodDash.interfaces.RestaurantDAO;
import java.util.Arrays;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantDAOImpl implements RestaurantDAO {
    private final int EN_PROCESO = 0;
    private final int ENVIADO = 1;
    private final int ENTREGADO = 2;
    private final int FINALIZADO = 3;
    private final int tiempo_preparacion = 15;

    @Override
    public void aceptar_pedido(Pedido pedido) {
        System.out.println("implementar...");
        //entablar conexion
        Connection conexion = null;
        String query = null;
        /////////////////////////777777///////////////////////////////////////////  TEST DATA
        int id_restaurant = 1;                                                  //  TEST DATA
        int id_cliente = 11111111;                                              //  TEST DATA
        //////////////////////////////////////////////////////////////////////////  TEST DATA
        String[] productos;
        String[] cantidades;
//        int id_restaurant = pedido.getId_pedido();
//        int id_cliente = pedido.getId_cliente();
        
        try {
            conexion = (Connection) Connector.getConnection();
            PreparedStatement statement = null;
            
            //establecer estado del pedido como "en proceso"
            cambiarEstado(id_restaurant, id_cliente, ENVIADO); //CAMBIAR ESTADO A EN_PROCESO AL TERMINAR DE PROBAR
            
            //conseguir productos y cantidades
            query = "select * from pedido where id_restaurant = "+id_restaurant+" and id_cliente = "+id_cliente;
            statement = conexion.prepareStatement(query);
            ResultSet tablaPedido = statement.executeQuery();
            
            //Inicializar [restaurant]
                Restaurant restaurant = new Restaurant();
            
            if (tablaPedido.next()) {
                System.out.println("productos: "+tablaPedido.getString("productos")); //productos en formato de array
                System.out.println("cantidades: "+tablaPedido.getInt("cantidades")); //cantidades en formato de array
                System.out.println("estado: "+ tablaPedido.getString("estado"));
                
                //recibir productos, cantidades, suma_precio del objeto o tabla [pedido]
                //y establecer los datos en la tabla y objeto restaurant
                
                productos = tablaPedido.getString("productos").split(", ");
                cantidades = tablaPedido.getString("cantidades").split(", ");
                
                restaurant.setId_restaurant(id_restaurant);
                restaurant.setId_pedido(tablaPedido.getInt("id_pedido"));
                ////////////////////77777777////////////////////////////////////////  TEST DATA
                restaurant.setNombre("TEST");                               //  TEST DATA
                restaurant.setTelefono(1112345678);                       //  TEST DATA
                ////////////////////////////////////////////////////////////////////  TEST DATA
                restaurant.setProductos(Arrays.asList(productos));
                restaurant.setCantidades(Arrays.asList(cantidades));

                //establecer tiempo_preparacion como el tiempo de preparacion del pedido
                pedido.setTiempo_preparacion(this.tiempo_preparacion);

            }
            //cerrar conexion
            conexion.close();
        
            System.out.println(pedido);
            System.out.println("-------------------------------------");
            System.out.println(restaurant);    
        }
        catch (SQLException ex) {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("gatillar envio: ");
        
        //una vez marcado el pedido como listo, gatillar envio
        System.out.println(gatillarEnvio());
    }

    @Override
    public void rechazar_pedido(Pedido pedido) {
        System.out.println("implementar...");
    }

    @Override
    public void finalizar_pedido(Pedido pedido) {
        System.out.println("implementar...");
        
        try
        {
            //cambiar estado del pedido
            cambiarEstado(pedido.getId_restaurant(), pedido.getId_cliente(), pedido.getEstado());
        }
        catch (SQLException ex)
        {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //cambiar el estado del pedido a uno predefinido
    public String cambiarEstado(int id_restaurant, int id_cliente, int estado)
            throws SQLException
    {
        String error = null;
        Connection conexion = Connector.getConnection();
        String[] estadosPosibles = {"en proceso", "enviado", "entregado", "finalizado"};
        
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
    
    public String gatillarEnvio()
    {
        return "implementar";
    }
}
