/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbcpizzeria_gastelumilian;

import Interfaz.IConexion;
import Objetos.Producto;
import dao.Conexion;
import dao.ProductoDAO;

/**
 *
 * @author Laboratorios
 */
public class JDBCPizzeria_GastelumIlian {

    public static void main(String[] args) {
        /*Conexion c = new Conexion();
        c.crearConexion();
        ProductoDAO producto = new ProductoDAO(c);
        
        //producto.agregar(new Producto("Pizza de Pepperoni", "Pizza sencilla con pepperoni", 89));
        //producto.agregar(new Producto("Pizza de Pepperoni y champinones", "Pizza sencilla con pepperoni y champinones", 110));
        //producto.agregar(new Producto("Pizza de Pepperoni con orilla rellena", "Pizza de pepperoni con orillas rellenas de queso", 140));
        
        producto.eliminar(13);
        
        System.out.println(producto.consultar(14));
        System.out.println(producto.consultar().toString());
        
        /*
        String cadenaConexion = "jdbc:mysql://localhost:3306/pizzeria_bda";
        String user = "root";
        String password = "itson";
        String i = "INSERT INTO Producto (nombre, precio, descripcion) VALUES (?,?,?)";
        String buscarProducto = "SELECT * FROM Producto WHERE precio < ?";
        
        try {
            Connection c = DriverManager.getConnection(cadenaConexion, user, password);
            PreparedStatement insert = c.prepareStatement(i, Statement.RETURN_GENERATED_KEYS);
            insert.setString(1, "Pizza de Campiñones");
            insert.setFloat(2, (float)100.0);
            insert.setString(3, "Pizza sencilla con base tomate y queso, con toppings de pepperoni y champiñones");
            
            insert.executeUpdate();
            
            PreparedStatement busqueda = c.prepareStatement(buscarProducto);
            busqueda.setFloat(1, 100);
            
            ResultSet resultados = busqueda.executeQuery();
            
            if(resultados.next()){
                String nombre = resultados.getString("nombre");
                float precio = resultados.getFloat("precio");
                String descripcion = resultados.getString("descripcion");
                
                System.out.println(nombre+" $"+precio);
                System.out.println(descripcion);
            }
            
        } catch (SQLException e) {
            
        }
        */
        
        
    }
}
