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
        <section id="form-tarea">
            <article id="publicacion-tarea">
                <h2>Introduzca los datos necesarios</h2>
                <form action="PublicarTarea" method="POST">
                    <label for="titulo_tarea">Titulo de la tarea: </label>
                    <input type="text" name="titulo_tarea" id="titulo_tarea"/>
                    <label for="descripcion_tarea">Descripción de la tarea (detalles de como hacerla): </label>
                    <textarea name="descripcion_tarea" id="descripcion_tarea"></textarea>
                    <label for="fecha_entrega_tarea">Fecha de entrega: </label>
                    <input type="date" id="fecha_entrega_tarea" name="fecha_entrega_tarea"/>
                    <label for="grupo_tarea">Grupo: </label>
                    <select id="grupo_tarea" name="grupo_tarea">
                        <c:forEach var="grupo" items="${grupos}">
                              <option value="${grupo}">${grupo}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Publicar Tarea"/>
                </form>
            </article>
        </section>
    </body>
</html>
