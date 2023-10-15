<%-- 
    Document   : UpdatePelicula
    Created on : 15/10/2023, 01:49:47 AM
    Author     : dchri
--%>

<%@page import="DAO.DAOpelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.CrudPelicula"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
            CrudPelicula ca = new CrudPelicula();
            DAOpelicula pelicula = ca.Search_id(idpelicula);
        %>
        <form action="NewServletUpdatePelicula" method="POST">
            <table>
            <tr>
                <td>id</td>
                <td><input type="text" name="id" id="id" value="<% out.print(pelicula.getID_PELICULA()); %>" readonly></td>
            </tr>
            <tr>
                <td>nombre</td>
                <td><input type="text" name="nom" id="nom" value="<% out.print(pelicula.getVCH_NOMBRE_PELICULA()); %>"></td>
            </tr>
            </table>
            <button type="submit">Actualizar</button>                    
        </form>
    </body>
</html>