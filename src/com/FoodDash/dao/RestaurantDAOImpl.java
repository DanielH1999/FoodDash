package com.FoodDash.dao;

import com.FoodDash.connector.Connection;
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
        try {
            conexion = Connection.getConnection();
            
            //establecer id_restaurant como el id de este restaurant
            //establecer estado como "en proceso"
            //conseguir id_pedido
            //conseguir productos
            //conseguir cantidades
            //establecer tiempo_preparacion como el tiempo de preparacion del pedido
            //establecer suma_precio como el precio de todos los productos en el pedido
            //cerrar conexion
            conexion.close();
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
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
