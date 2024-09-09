/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interfaz.IConexion;
import Interfaz.IProductoDAO;
import Objetos.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laboratorios
 */
public class ProductoDAO implements IProductoDAO{

    private IConexion conexion;
    
    public ProductoDAO(IConexion conexion){
        this.conexion=conexion;
    }
    
    @Override
    public boolean agregar(Producto producto) {
        Connection bd = conexion.crearConexion();
        String insertar ="INSERT INTO Producto (nombre, precio, descripcion) VALUES (?,?,?)";
        try {
            PreparedStatement i = bd.prepareStatement(insertar);
            i.setString(1, producto.getNombre());
            i.setFloat(2, producto.getPrecio());
            i.setString(3, producto.getDescripcion());
            
            i.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No se pudo agregar el producto");
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        Connection bd = conexion.crearConexion();
        String eliminar ="DELETE FROM Producto WHERE ID = ?";
        try {
            PreparedStatement i = bd.prepareStatement(eliminar);
            i.setInt(1, id);
            
            i.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar");
            return false;
        }
    }

    @Override
    public boolean actualizar(Producto producto) {
        Connection bd = conexion.crearConexion();
        String actualizar ="UPDATE Producto SET Nombre = ?, Precio= ?, Descripcion = ? WHERE ID = ?";
        try {
            PreparedStatement i = bd.prepareStatement(actualizar);
            i.setString(1, producto.getNombre());
            i.setFloat(2, producto.getPrecio());
            i.setString(3, producto.getDescripcion());
            i.setInt(4, producto.getId());
            i.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar");
            return false;
        }
    }

    @Override
    public Producto consultar(int id) {
        Connection bd = conexion.crearConexion();
        String buscarProducto = "SELECT * FROM Producto WHERE ID = (?)";
        try {
            PreparedStatement busqueda = bd.prepareStatement(buscarProducto);
            busqueda.setInt(1, id);
            
            ResultSet resultados = busqueda.executeQuery();
            
            if(resultados.next()){
                Producto p = new Producto();
                p.setId(resultados.getInt("ID"));
                p.setNombre(resultados.getString("Nombre"));
                p.setPrecio(resultados.getFloat("Precio"));
                p.setDescripcion(resultados.getString("Descripcion"));
                return p;
            }
            else{
            }
            
        } catch (SQLException e) {
            System.out.println("No se pudo consultar");
            
            
        }
        return null;
        
    }

    @Override
    public List<Producto> consultar() {
        Connection bd = conexion.crearConexion();
        String buscarProducto = "SELECT * FROM Producto";
        List<Producto> productos = new ArrayList<>();
        try {
            PreparedStatement busqueda = bd.prepareStatement(buscarProducto);
            
            ResultSet resultados = busqueda.executeQuery();
            
            while(resultados.next()){
                Producto p = new Producto();
                p.setId(resultados.getInt("ID"));
                p.setNombre(resultados.getString("Nombre"));
                p.setPrecio(resultados.getFloat("Precio"));
                p.setDescripcion(resultados.getString("Descripcion"));
                productos.add(p);
            }
            
            
        } catch (SQLException e) {
            System.out.println("No se pudo consultar");
            
        }
        return productos;
    }
    
}
