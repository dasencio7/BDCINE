<%-- 
    Document   : EliminarPelicula
    Created on : 15/10/2023, 01:49:36 AM
    Author     : dchri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
            String npelicula = request.getParameter("npelicula");
        %>
        <table>
            <tr>
                <td>id</td>
                <td><% out.print(idpelicula); %></td>
            </tr>
            <tr>
                <td>nombre</td>
                <td><% out.print(npelicula); %></td>
            </tr>
            <tr>
                <td colspan="2">
                    <form action="NewServletEliminarPelicula" method="POST">
                        <input type=hidden id=idpelicula name=idpelicula value=<% out.print(idpelicula); %>>
                        <button type="submit">Eliminar</button>                    
                    </form>
                </td>        
            </tr>
        </table>
    </body>
</html>