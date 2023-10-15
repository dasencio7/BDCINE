<%-- 
    Document   : UpdateGenero
    Created on : 15/10/2023, 02:31:25 PM
    Author     : dchri
--%>

<%@page import="DAO.DAOgenero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.CrudGenero"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int idgenero = Integer.parseInt(request.getParameter("idgenero"));
            CrudGenero ca = new CrudGenero();
            DAOgenero genero = ca.Search_id(idgenero);
        %>
        <form action="NewServletUpdateGenero" method="POST">
            <table>
            <tr>
                <td>id</td>
                <td><input type="text" name="id" id="id" value="<% out.print(genero.getID_GENERO()); %>" readonly></td>
            </tr>
            <tr>
                <td>nombre</td>
                <td><input type="text" name="nom" id="nom" value="<% out.print(genero.getVCH_NOMBRE_GENERO()); %>"></td>
            </tr>
            </table>
            <button type="submit">Actualizar</button>                    
        </form>
    </body>
</html>