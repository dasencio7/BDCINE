/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.DAOpelicula;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author dchri
 */
public class CrudPelicula {
    Conexion conexion = new Conexion();
    public String Create(Object obj) throws SQLException{
       DAOpelicula pelicula = (DAOpelicula) obj;
       Connection connection;
       PreparedStatement pst;
       String query = "INSERT INTO TBL_PELICULA VALUES (?)";
       String respuesta;
      
      try{
          Class.forName(conexion.getDriver());
          connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
          
          pst = (PreparedStatement) connection.prepareStatement(query);
          pst.setString(1 , pelicula.getVCH_NOMBRE_PELICULA());
          respuesta = Integer.toString(pst.executeUpdate());
        }
      catch(ClassNotFoundException | SQLException ex){
          respuesta = ex.getMessage();
        }
      return respuesta;
    }

   public List<DAOpelicula> Read_Search(String parametro) {
    Connection connection;
    PreparedStatement pst;
    String query = "SELECT * FROM TBL_PELICULA WHERE VCH_NOMBRE_PELICULA = ?";
    ResultSet rs;

    List<DAOpelicula> ListaPelicula = new ArrayList<>();
    try {
        Class.forName(conexion.getDriver());
        connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
        pst = connection.prepareStatement(query);
        pst.setString(1, parametro); // Configurar el valor de parametro
        rs = pst.executeQuery();
        while (rs.next()) {
            DAOpelicula Peliculas = new DAOpelicula();
            Peliculas.setID_PELICULA(rs.getInt("ID_PELICULA"));
            Peliculas.setVCH_NOMBRE_PELICULA(rs.getString("VCH_NOMBRE_PELICULA"));
            ListaPelicula.add(Peliculas);
        }
        rs.close();
    } catch (SQLException | ClassNotFoundException ex) {
        ex.getMessage();
    }
    return ListaPelicula;
    
    }
   
   public String Delete(Object obj){
       int id_pelicula = (int)obj;
       Connection connection;
       PreparedStatement pst;
       String query = "DELETE FROM TBL_PELICULA WHERE ID_PELICULA = '"+id_pelicula+"'";
       String respuesta;
       try{
          Class.forName(conexion.getDriver());
          connection = (Connection) DriverManager.getConnection(conexion.getUrl(), 
                  conexion.getUsuario(), conexion.getPassword());
          pst = (PreparedStatement) connection.prepareStatement(query);
          pst.executeUpdate();
          respuesta = "Pelicula eliminada con éxito";
        }
      catch(ClassNotFoundException | SQLException ex){
          respuesta = ex.getMessage();
        }
      return respuesta;
   }
   
      public DAOpelicula Search_id(int parametro) {
    DAOpelicula Peliculas = new DAOpelicula();
    Connection connection;
    PreparedStatement pst;
    String query = "SELECT * FROM TBL_PELICULA WHERE ID_PELICULA = " + parametro;
    ResultSet rs;

    try {
        Class.forName(conexion.getDriver());
        connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
        pst = connection.prepareStatement(query);
        rs = pst.executeQuery();
        while (rs.next()) {
            Peliculas.setID_PELICULA(rs.getInt("ID_PELICULA"));
            Peliculas.setVCH_NOMBRE_PELICULA(rs.getString("VCH_NOMBRE_PELICULA"));
        }
        rs.close();     
    } 
        catch (SQLException | ClassNotFoundException ex) {
        ex.getMessage();
    }
    return Peliculas;
    
    }

    public String Update(Object obj) {
        DAOpelicula pelicula = (DAOpelicula) obj;
        Connection connection;
        PreparedStatement pst;
        String query = "UPDATE TBL_PELICULA SET VCH_NOMBRE_PELICULA = '" + pelicula.getVCH_NOMBRE_PELICULA() + "' WHERE ID_PELICULA = " + pelicula.getID_PELICULA();
        String respuesta;
        
        try{
          Class.forName(conexion.getDriver());
          connection = (Connection) DriverManager.getConnection(conexion.getUrl(), 
                  conexion.getUsuario(), conexion.getPassword());
          pst = (PreparedStatement) connection.prepareStatement(query);
          pst.executeUpdate();
          respuesta = "Registro actualizado con éxito";
        }
        catch(ClassNotFoundException | SQLException ex){
          respuesta = ex.getMessage();
        }
        return respuesta;
    }
}