package com.FoodDash.entities;

import java.sql.*;

public class Cliente {
    
    private int id;
    private String Nombre;
    private String Direccion;
    private int Telefono;
    
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return Telefono;
    }
    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public static void elegirRestaurante(String restaurante) throws SQLException {
        Connection conexion = Connection.getConnection();
        
        String consulta = "select * from restaurant where nombre = '"+restaurante+"'";
        
        Statement sentenciaConsulta = conexion.createStatement();
        
        ResultSet resultadoNombre = sentenciaConsulta.executeQuery(consulta);
        
        int idRestaurante = resultadoNombre.getInt("id_restaurant");
        
        String insercion = "INSERT INTO pedido(id_restaurant,tiempo_preparacion,estado) values ("+idRestaurante+",10,'Pendiente')";
        
        System.out.println("Insercion Exitosa");
        
        conexion.close();
    }
    
    public static String seleccionarProducto (String producto) {
        
    }

}
