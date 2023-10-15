/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author dchri
 */
public class DAOgenero {
    private int _ID_GENERO;
    private String _VCH_NOMBRE_GENERO;
   
    public void setID_GENERO(int _ID_GENERO) {
        this._ID_GENERO = _ID_GENERO;
    }

    public int getID_GENERO() {
        return _ID_GENERO;
    }
   
    
    public String getVCH_NOMBRE_GENERO() {
        return _VCH_NOMBRE_GENERO;
    }
 
    public void setVCH_NOMBRE_GENERO(String _VCH_NOMBRE_GENERO) {
        this._VCH_NOMBRE_GENERO = _VCH_NOMBRE_GENERO;
    }
    public DAOgenero() {  
    }
 
    public DAOgenero(int _ID_GENERO, String _VCH_NOMBRE_GENERO) {
        this._ID_GENERO = _ID_GENERO;
        this._VCH_NOMBRE_GENERO = _VCH_NOMBRE_GENERO;
    }
    
    public Boolean ValidaSubida( String nom){
        Boolean flag = true;
        if(!nom.isEmpty()){ setVCH_NOMBRE_GENERO(nom); }else{return false;}
        
        return flag;
    }
    public Boolean ValidaSubida(int id, String nom){
        Boolean flag = true;
        if(id>0) { setID_GENERO(id); }else{return false;}
        if(!nom.isEmpty()){ setVCH_NOMBRE_GENERO(nom); }else{return false;}
        
        return flag;
    
    }
}