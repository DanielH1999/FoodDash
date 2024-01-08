package com.FoodDash.dao;

import com.FoodDash.connector.Connector;
import com.FoodDash.entities.Envio;
import com.FoodDash.interfaces.EnvioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnvioDAOImpl implements EnvioDAO
{
	@Override
	public void ingresarEnvio(Envio envio)
	{
		try {
			Connection conexion = (Connection) Connector.getConnection();
			String query = "INSERT INTO envio (id_restaurant, direccion, medio_pago, precio_envio, estado) VALUES (?,?,?,?,?)";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, envio.getId_restaurant());
			statement.setString(2, envio.getDireccion());
			statement.setString(3, envio.getMedioPago());
			statement.setInt(4, envio.getPrecioEnvio());
			statement.setString(5, envio.getEstadoString());
			statement.executeUpdate();
			conexion.close();
		} catch (SQLException ex) {
			Logger.getLogger(EnvioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
			
	@Override
	public void actualizarEnvio(Envio envio)
	{
		try {
			Connection conexion = (Connection) Connector.getConnection();
			String query = "UPDATE envio SET id_restaurant = ?, direccion = ?, medio_pago = ?, precio_envio = ?, estado = ? WHERE id_envio = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, envio.getId_restaurant());
			statement.setString(2, envio.getDireccion());
			statement.setString(3, envio.getMedioPago());
			statement.setInt(4, envio.getPrecioEnvio());
			statement.setString(5, envio.getEstadoString());
			statement.setInt(6, envio.getId_envio());
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(EnvioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

    
}
