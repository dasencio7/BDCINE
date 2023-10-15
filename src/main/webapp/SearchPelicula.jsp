<%-- 
    Document   : SearchPelicula
    Created on : 15/10/2023, 01:49:15 AM
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
        <form action="ServletSearchPelicula" method="POST">
            <input type="text" id="nombre" name="nombre">
            <button type="submit">Enviar</button>
        </form>
        ${respuesta}
    </body>
</html>