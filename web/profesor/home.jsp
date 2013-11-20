<%-- 
    Document   : home
    Created on : 01-nov-2013, 1:07:18
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="../css/style.css">
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
    </head>
    
    <body>
        <header>
            <h1>Hola ${nombre}</h1>
            <a href="../Logout">Salir</a>
            <nav id="lateral-menu">
                <aside>
                  <h3>Menu</h3>
                  <ul>
                    <li><a href="#">Inicio</a></li>
                    <li><a href="entregas.jsp">Entregas</a></li>
                    <li><a href="publicar.jsp">Publicar</a></li>
                  </ul>
                </aside> 
            </nav>
        </header>
        <section id="main">
            <section>
                <div class="publicar">
                    <form action="../LoadPublicacion" id="form_publicar" method="POST">
                        <input type="text" name="titulo" placeholder="Titulo"/>
                        <input type="text" name="descripcion" placeholder="Descripción"/>
                        <select name="grupo">
                        <c:forEach var="grupo" items="${grupos}">
                              <option value="${grupo}">${grupo}</option>
                        </c:forEach>   
                        </select>
                        <input type="date" name="fecha"/>
                        <input type="submit" value="Publicar"/>
                    </form>
                </div>
            </section>
            <section id="feed-tareas-revisar">
                <h2>Revisiones pendientes</h2>
                
                <article class="tarea pendiente" id="tarea-231sqsdewq987ab">
                    <div id="titulo-tarea">{{titulo_tarea}}</div>
                    <div id="nombre-alumno-tarea">{{nombre_alumno_tarea}}</div>
                    <div id="grupo-alumno-tarea">{{grupo_alumno_tarea}}</div>
                    <div id="contenido-tarea">{{contenido_tarea}}</div>
                    <div id="fecha-entrega-tarea">{{fecha_entrega_tarea}}</div>
                    <div id="fecha-entregada-tarea">{{fecha_entregada_tarea}}</div>
                    <div id="desplazar-comentarios-tarea"><a href="revisar.jsp?mostrar_comentarios=true&id_tarea=231sqsdewq987ab">Mostrar Comentarios</a></div>
                </article>
                <article class="tarea atrasada" id="tarea-231sqsdewq987ab">
                    <div id="titulo-tarea">{{titulo_tarea}}</div>
                    <div id="nombre-alumno-tarea">{{nombre_alumno_tarea}}</div>
                    <div id="grupo-alumno-tarea">{{grupo_alumno_tarea}}</div>
                    <div id="contenido-tarea">{{contenido_tarea}}</div>
                    <div id="fecha-entrega-tarea">{{fecha_entrega_tarea}}</div>
                    <div id="fecha-entregada-tarea">{{fecha_entregada_tarea}}</div>
                    <div id="desplazar-comentarios-tarea"><a href="revisar.jsp?mostrar_comentarios=true&id_tarea=231sqsdewq987ab">Mostrar Comentarios</a></div>
                </article>
            </section>
        </section>
    </body>
</html>
