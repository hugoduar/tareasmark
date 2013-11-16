<%-- 
    Document   : publicar
    Created on : 15-nov-2013, 1:01:55
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
        <header>
            <h1>Hola ${nombre}</h1>
            <a href="../Logout">Salir</a>
            <nav id="lateral-menu">
                <aside>
                  <h3>Mail</h3>
                  <ul>
                    <li><a href="home.jsp">Inicio</a></li>
                    <li><a href="entregas.jsp">Entregas</a></li>
                    <li><a href="#">Publicar</a></li>
                  </ul>
                </aside> 
            </nav>
        </header>
    </body>
</html>
