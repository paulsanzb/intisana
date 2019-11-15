/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanzmat.dao;

import java.sql.*;

/**
 *
 * @author pauls
 */
public class Consullta {
    public static void main(String[] args) throws SQLException {
        
        String url;
        url="jdbc:mysql://localhost:3306/c2c?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try
        {
            Connection conexion;
            conexion = DriverManager.getConnection(url,"root","password");
            Statement instruccionSQl = conexion.createStatement();
            
            String sql = "SELECT idTrabajadores, Nombres,Apellidos,correo,cedula,telefono FROM trabajadores";
            ResultSet resultado = instruccionSQl.executeQuery(sql);
            
            while (resultado.next())
            {
                System.out.println("Id trabajador: " + resultado.getInt(1));
                System.out.println("Nombres: " + resultado.getString(2));
                System.out.println("Apellidos: " + resultado.getString(3));
                System.out.println("Correo: " + resultado.getString(4));
                System.out.println("Cedula: " + resultado.getString(5));
                System.out.println("Telefono: " + resultado.getString(6));
            }
            resultado.close();
            instruccionSQl.close();
            conexion.close();
        } catch (SQLException ex) 
        {
            ex.printStackTrace(System.out);
        }
        
        
        System.out.print("intro to JDBC");
    }
    
}
