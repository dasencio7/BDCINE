/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.DAOgenero;
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
public class CrudGenero {
    Conexion conexion = new Conexion();
    public String Create(Object obj) throws SQLException{
       DAOgenero genero = (DAOgenero) obj;
       Connection connection;
       PreparedStatement pst;
       String query = "INSERT INTO TBL_GENERO VALUES (?)";
       String respuesta;
      
      try{
          Class.forName(conexion.getDriver());
          connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
          
          pst = (PreparedStatement) connection.prepareStatement(query);
          pst.setString(1 , genero.getVCH_NOMBRE_GENERO());
          respuesta = Integer.toString(pst.executeUpdate());
        }
      catch(ClassNotFoundException | SQLException ex){
          respuesta = ex.getMessage();
        }
      return respuesta;
    }

   public List<DAOgenero> Read_Search(String parametro) {
    Connection connection;
    PreparedStatement pst;
    String query = "SELECT * FROM TBL_GENERO WHERE VCH_NOMBRE_GENERO = ?";
    ResultSet rs;

    List<DAOgenero> ListaGenero = new ArrayList<>();
    try {
        Class.forName(conexion.getDriver());
        connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
        pst = connection.prepareStatement(query);
        pst.setString(1, parametro); // Configurar el valor de parametro
        rs = pst.executeQuery();
        while (rs.next()) {
            DAOgenero Generos = new DAOgenero();
            Generos.setID_GENERO(rs.getInt("ID_GENERO"));
            Generos.setVCH_NOMBRE_GENERO(rs.getString("VCH_NOMBRE_GENERO"));
            ListaGenero.add(Generos);
        }
        rs.close();
    } catch (SQLException | ClassNotFoundException ex) {
        ex.getMessage();
    }
    return ListaGenero;
    
    }
   
   public String Delete(Object obj){
       int id_genero = (int)obj;
       Connection connection;
       PreparedStatement pst;
       String query = "DELETE FROM TBL_GENERO WHERE ID_GENERO = '"+id_genero+"'";
       String respuesta;
       try{
          Class.forName(conexion.getDriver());
          connection = (Connection) DriverManager.getConnection(conexion.getUrl(), 
                  conexion.getUsuario(), conexion.getPassword());
          pst = (PreparedStatement) connection.prepareStatement(query);
          pst.executeUpdate();
          respuesta = "Genero eliminado con éxito";
        }
      catch(ClassNotFoundException | SQLException ex){
          respuesta = ex.getMessage();
        }
      return respuesta;
   }
   
      public DAOgenero Search_id(int parametro) {
    DAOgenero Generos = new DAOgenero();
    Connection connection;
    PreparedStatement pst;
    String query = "SELECT * FROM TBL_GENERO WHERE ID_genero = " + parametro;
    ResultSet rs;

    try {
        Class.forName(conexion.getDriver());
        connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
        pst = connection.prepareStatement(query);
        rs = pst.executeQuery();
        while (rs.next()) {
            Generos.setID_GENERO(rs.getInt("ID_GENERO"));
            Generos.setVCH_NOMBRE_GENERO(rs.getString("VCH_NOMBRE_GENERO"));
        }
        rs.close();     
    } 
        catch (SQLException | ClassNotFoundException ex) {
        ex.getMessage();
    }
    return Generos;
    
    }

    public String Update(Object obj) {
        DAOgenero genero = (DAOgenero) obj;
        Connection connection;
        PreparedStatement pst;
        String query = "UPDATE TBL_GENERO SET VCH_NOMBRE_GENERO = '" + genero.getVCH_NOMBRE_GENERO() + "' WHERE ID_GENERO = " + genero.getID_GENERO();
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