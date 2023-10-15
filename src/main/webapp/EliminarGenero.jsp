<%-- 
    Document   : EliminarGenero
    Created on : 15/10/2023, 02:31:12 PM
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
            int idgenero = Integer.parseInt(request.getParameter("idgenero"));
            String ngenero = request.getParameter("ngenero");
        %>
        <table>
            <tr>
                <td>id</td>
                <td><% out.print(idgenero); %></td>
            </tr>
            <tr>
                <td>nombre</td>
                <td><% out.print(ngenero); %></td>
            </tr>
            <tr>
                <td colspan="2">
                    <form action="NewServletEliminarGenero" method="POST">
                        <input type=hidden id=idgenero name=idpelicula value=<% out.print(idgenero); %>>
                        <button type="submit">Eliminar</button>                    
                    </form>
                </td>        
            </tr>
        </table>
    </body>
</html>