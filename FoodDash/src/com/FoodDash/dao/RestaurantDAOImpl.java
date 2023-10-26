package com.FoodDash.dao;

import com.FoodDash.connector.*;
import com.FoodDash.entities.Restaurant;
import com.FoodDash.interfaces.RestaurantDAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantDAOImpl implements RestaurantDAO {

    @Override
    public void aceptar_pedido() {
        System.out.println("implementar...");
        //entablar conexion
        Connection conexion = null;
        String consulta = null;
        int id_restaurant = 1; //cambiar al id del restaurant actual
        int id_cliente = 11111111; //cambiar al id del cliente correspondiente al pedido
        try {
            conexion = (Connection) Connector.getConnection();
            PreparedStatement statement = null;
            
            //establecer estado del pedido como "en proceso"
            consulta = "update pedido set estado = 'en proceso' where id_restaurant = ? and id_cliente = ?";
            
            statement = conexion.prepareStatement(consulta);
            
            statement.setInt(1, id_restaurant);
            statement.setInt(2, id_cliente);
            
            statement.execute();
            //conseguir productos
                //conseguir cantidades
            //establecer tiempo_preparacion como el tiempo de preparacion del pedido
            //establecer suma_precio como el precio de todos los productos en el pedido
            //cerrar conexion
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rechazar_pedido() {
        System.out.println("implementar...");
    }

    @Override
    public void finalizar_pedido() {
        System.out.println("implementar");
    }
    
}
