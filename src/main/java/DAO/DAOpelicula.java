/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author dchri
 */
public class DAOpelicula {
    private int _ID_PELICULA;
    private String _VCH_NOMBRE_PELICULA;
   
    public void setID_PELICULA(int _ID_PELICULA) {
        this._ID_PELICULA = _ID_PELICULA;
    }

    public int getID_PELICULA() {
        return _ID_PELICULA;
    }
   
    
    public String getVCH_NOMBRE_PELICULA() {
        return _VCH_NOMBRE_PELICULA;
    }
 
    public void setVCH_NOMBRE_PELICULA(String _VCH_NOMBRE_PELICULA) {
        this._VCH_NOMBRE_PELICULA = _VCH_NOMBRE_PELICULA;
    }
    public DAOpelicula() {  
    }
 
    public DAOpelicula(int _ID_PELICULA, String _VCH_NOMBRE_PELICULA) {
        this._ID_PELICULA = _ID_PELICULA;
        this._VCH_NOMBRE_PELICULA = _VCH_NOMBRE_PELICULA;
    }
    
    public Boolean ValidaSubida( String nom){
        Boolean flag = true;
        if(!nom.isEmpty()){ setVCH_NOMBRE_PELICULA(nom); }else{return false;}
        
        return flag;
    }
    public Boolean ValidaSubida(int id, String nom){
        Boolean flag = true;
        if(id>0) { setID_PELICULA(id); }else{return false;}
        if(!nom.isEmpty()){ setVCH_NOMBRE_PELICULA(nom); }else{return false;}
        
        return flag;
    
    }
}