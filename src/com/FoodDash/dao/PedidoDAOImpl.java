package com.FoodDash.dao;

import com.FoodDash.entities.Cliente;
import com.FoodDash.entities.Restaurant;
import com.FoodDash.interfaces.PedidoDAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.FoodDash.connector.Connector;
import com.FoodDash.entities.Pedido;
import java.util.logging.Level;
import java.util.logging.Logger;


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
	
	/**
	 * CONSIGUE EL ULTIMO ID DE PEDIDO DE LA BASE DE DATOS Y DEVUELVE ESE NUMERO + 1
	 *  USO: CREACION DE NUEVOS ID DE PEDIDO PREVIO AL INGRESO EN LA BASE DE DATOS
	 */
	public int obtenerId_pedido()
	{
		int siguiente_pedido = -1;
		try {
			Connection conexion = (Connection) Connector.getConnection();
			String query = "SELECT MAX(id_pedido) + 1 FROM pedido";
			PreparedStatement statement = conexion.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				siguiente_pedido = rs.getInt(1);
			}
			conexion.close();
		} catch (SQLException ex) {
			Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return siguiente_pedido;
}
	
	public void ingresarPedido(Pedido pedido)
	{
		try {
			Connection conexion = (Connection) Connector.getConnection();
			String query = "INSERT INTO pedido (id_pedido, id_cliente, id_restaurant, productos, cantidades, suma_precio, tiempo_preparacion, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, pedido.getId_pedido());
			statement.setInt(2, pedido.getId_cliente());
			statement.setInt(3, pedido.getId_restaurant());
			statement.setString(4, pedido.getProductosString());
			statement.setString(5, pedido.getCantidadesString());
			statement.setFloat(6, pedido.getSuma_precio());
			statement.setInt(7, pedido.getTiempo_preparacion());
			statement.setString(8, pedido.getEstadoString());
			statement.executeUpdate();
			conexion.close();
		} catch (SQLException ex) {
			Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@Override
	public void actualizarPedido(Pedido pedido) 
	{
		try {
			Connection conexion = (Connection) Connector.getConnection();
			String query = "UPDATE pedido SET id_cliente = ?, id_restaurant = ?, productos = ?, cantidades = ?, suma_precio = ?, tiempo_preparacion = ?, estado = ? WHERE id_pedido = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, pedido.getId_cliente());
			statement.setInt(2, pedido.getId_restaurant());
			statement.setString(3, pedido.getProductosString());
			statement.setString(4, pedido.getCantidadesString());
			statement.setFloat(5, pedido.getSuma_precio());
			statement.setInt(6, pedido.getTiempo_preparacion());
			statement.setString(7, pedido.getEstadoString());
			statement.setInt(8, pedido.getId_pedido());
			conexion.close();
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			Connection conexion = (Connection) Connector.getConnection();
			String query = "SELECT * FROM cliente";
			PreparedStatement statement = conexion.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id_cliente = rs.getInt("id_cliente");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				int telefono = rs.getInt("telefono");
				Cliente cliente = new Cliente(id_cliente, nombre, telefono, direccion);
				clientes.add(cliente);
			}
			conexion.close();
		} catch (SQLException ex) {
			Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return clientes;
	}

	@Override
	public List<Restaurant> getRestaurants() {
		List<Restaurant> restaurants = new ArrayList<>();
		try {
			Connection conexion = (Connection) Connector.getConnection();
			String query = "SELECT * FROM restaurant";
			PreparedStatement statement = conexion.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id_restaurant = rs.getInt("id_restaurant");
				int id_envio = rs.getInt("id_envio");
				String nombre = rs.getString("nombre");
				int telefono = rs.getInt("telefono");
				Restaurant restaurant = new Restaurant(id_restaurant, /*-1,*/ id_envio, nombre, telefono);
				restaurants.add(restaurant);
			}
			conexion.close();
		} catch (SQLException ex) {
			Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return restaurants;
	}
}
