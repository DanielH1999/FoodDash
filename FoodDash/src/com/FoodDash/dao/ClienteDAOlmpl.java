package com.FoodDash.dao;

import com.FoodDash.*;
import com.FoodDash.connector.Connector;
import com.FoodDash.entities.Cliente;
import com.FoodDash.entities.Envio;
import com.FoodDash.entities.Pedido;
import com.FoodDash.entities.Restaurant;
import com.FoodDash.interfaces.ClienteDAO;
import java.util.Arrays;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAOlmpl implements ClienteDAO{

public void ingresarDatos(Cliente c) throws SQLException {
        Connection conexion = Connector.getConnection();

        String consulta = "SELECT id_cliente FROM cliente where id_cliente="+c.getId();
        String insercionCliente = "INSERT INTO cliente(id_cliente, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";
        String actualizacionCliente = "UPDATE cliente SET nombre=?, direccion=?, telefono=? WHERE id_cliente =?";
        
        Statement consultaCliente = conexion.createStatement();
        
        ResultSet resultadoQuery = consultaCliente.executeQuery(consulta);
        
        
        if (resultadoQuery.next()== true) 
        {
           PreparedStatement codigoEjecutar = conexion.prepareStatement(actualizacionCliente);
           
           codigoEjecutar.setString(1, c.getNombre());
           codigoEjecutar.setString(2, c.getDireccion());
           codigoEjecutar.setInt(3, c.getTelefono());
           codigoEjecutar.setInt(4, c.getId());
        
           codigoEjecutar.execute();
            System.out.println("Actualizacion Hecha");
        } 
        else 
        {
           PreparedStatement codigoEjecutar = conexion.prepareStatement(insercionCliente);
           codigoEjecutar.setInt(1, c.getId());
           codigoEjecutar.setString(2, c.getNombre());
           codigoEjecutar.setString(3, c.getDireccion());
           codigoEjecutar.setInt(4, c.getTelefono());
        
           codigoEjecutar.execute();
            System.out.println("Insercion Hecha");
        }
        
        conexion.close();
        
    }
    
    
public void realizarPedido(Cliente c, Pedido p, Restaurant r) throws SQLException {
        Connection conexion = Connector.getConnection();
        
        String insercionPedido = "INSERT INTO pedido(id_cliente, id_restaurant, productos, cantidades, suma_precio, tiempo_preparacion, estado) values (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement segundaSentencia = conexion.prepareStatement(insercionPedido);
                
        segundaSentencia.setInt(1, c.getId());
        segundaSentencia.setInt(2, r.getId_restaurant());
        segundaSentencia.setString(3, p.getProductosString());
        segundaSentencia.setString(4, p.getCantidadesString());
        segundaSentencia.setFloat(5, p.getSuma_precio());
        segundaSentencia.setInt(6, 10);
        segundaSentencia.setString(7, "Realizado");
        
        segundaSentencia.execute();
        
        int idCliente = c.getId();
        
        String query = "SELECT MAX(id_pedido) as idPedido FROM pedido WHERE id_cliente = "+idCliente+";";
         
        Statement tercerSentencia = conexion.createStatement();
        
        ResultSet resultadoQuery = tercerSentencia.executeQuery(query);
        
        if (resultadoQuery.next()) {
           int idPedidoBase = resultadoQuery.getInt("idPedido");
           p.setId_pedido(idPedidoBase);
        }
        
        conexion.close();
    }

//    @Override
//    public void realizarPedido() {}

	@Override
	public void ingresarCliente(Cliente cliente) {
	try {
		Connection conexion = (Connection) Connector.getConnection();
		String query = "INSERT INTO cliente (id_cliente, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = conexion.prepareStatement(query);
		statement.setInt(1, cliente.getId());
		statement.setString(2, cliente.getNombre());
		statement.setString(3, cliente.getDireccion());
		statement.setInt(4, cliente.getTelefono());
		statement.executeUpdate();
		conexion.close();
	} catch (SQLException ex) {
		Logger.getLogger(ClienteDAOlmpl.class.getName()).log(Level.SEVERE, null, ex);
	}
}


	@Override
	public void actualizarCliente(Cliente cliente) {
		try {
			Connection conexion = (Connection) Connector.getConnection();
			String query = "UPDATE cliente SET nombre = ?, direccion = ?, telefono = ? WHERE id_cliente = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setString(1, cliente.getNombre());
			statement.setString(2, cliente.getDireccion());
			statement.setInt(3, cliente.getTelefono());
			statement.setInt(4, cliente.getId());
			statement.executeUpdate();
			conexion.close();
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAOlmpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
//	El método checkMatches es un método que busca en la base de datos un cliente que tenga los mismos valores de nombre, direccion y telefono que el objeto cliente pasado como parámetro.
//	Si se encuentra un cliente con los mismos valores, el método devuelve el valor de id_cliente de ese cliente.
//	De lo contrario, devuelve -1.
	public int checkMatches(Cliente cliente)
	{
		int id_cliente = -1;
		try{
			Connection conexion = (Connection) Connector.getConnection();
			String query = "SELECT * FROM cliente WHERE nombre = ? AND direccion = ? AND telefono = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setString(1, cliente.getNombre());
			statement.setString(2, cliente.getDireccion());
			statement.setInt(3, cliente.getTelefono());
			ResultSet database = statement.executeQuery();
			if (database.next())
			{
				return database.getInt("id_cliente");
			}
			conexion.close();
		}
		catch(SQLException e)
		{
			Logger.getLogger(ClienteDAOlmpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return id_cliente;
	}
	
	public Cliente obtenerCliente(int id_cliente)
	{
		Cliente cliente = null;
		try
		{
			Connection conexion = (Connection) Connector.getConnection();
			String query = "SELECT * FROM cliente WHERE id_cliente = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, id_cliente);
			ResultSet database = statement.executeQuery();
			if (database.next()) {
				cliente = new Cliente(id_cliente, database.getString("nombre"), database.getInt("telefono"), database.getString("direccion"));
			}
			conexion.close();
		}catch(SQLException e){
			Logger.getLogger(ClienteDAOlmpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return cliente;
	}
}
    
