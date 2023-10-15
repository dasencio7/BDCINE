/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOpelicula;
import Model.CrudPelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dchri
 */
public class ServletSearchPelicula extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String parametro = request.getParameter("nombre");
        CrudPelicula pelicula = new CrudPelicula();
        List<DAOpelicula> listarPelicula = pelicula.Read_Search(parametro);
        
        String respuesta = "";
        if(!listarPelicula.isEmpty()){
            for(int i = 0; i < listarPelicula.size(); i++){
                respuesta += elementBuilder(listarPelicula.get(i));
            }
            request.setAttribute("respuesta","<div class='formulario'>"+respuesta+"</div>");
            request.getRequestDispatcher("SearchPelicula.jsp").forward(request, response);

        }else{
            String mensaje = "<div class='formulario'><label class=\"label-item\"><b>"
                + "No se han encontrado elementos para la búsqueda: " + parametro + "</b></label></div>";
            request.setAttribute("respuesta", mensaje);
            request.getRequestDispatcher("SearchPelicula.jsp").forward(request, response); 
            }

    }
    
    protected String elementBuilder(DAOpelicula listarPelicula){
        String opentable = "<table class=\"tableVenta\" align=\"center\" "
                + "style=\"display:inline-block\">";
        
        
        
        String id = "<tr><td><label class=\"label-item\"><b>"+listarPelicula.getID_PELICULA()+
                "</b></1abel></td></tr>";
        String nombre = "<tr><td><label class=\"label-item\"><b>"+listarPelicula.getVCH_NOMBRE_PELICULA()+
                "</b></1abel></td></tr>";
        String eliminar = "<tr><td><form action=EliminarPelicula.jsp method=POST>" +
                "<input type=hidden id=idpelicula name=idpelicula value="+listarPelicula.getID_PELICULA()+">"+
                "<input type=hidden id=npelicula name=npelicula value="+listarPelicula.getVCH_NOMBRE_PELICULA()+">"+
                "<button type=submit>Eliminar</button></form></td></tr>";
        String actualizar =  "<tr><td><form action=UpdatePelicula.jsp method=POST>" +
                "<input type=hidden id=idpelicula name=idpelicula value="+listarPelicula.getID_PELICULA()+">"+
                "<button type=submit>Actualizar</button></form></td></tr>";
        
        String closetable =
            "</table>";

        String elemento = opentable + id + nombre + eliminar + actualizar + closetable;
        return elemento;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
