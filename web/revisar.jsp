<%-- 
    Document   : revisar
    Created on : 01-nov-2013, 1:25:49
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revisar Tarea</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <h1>Revisar las tareas pendientes</h1>
            <nav id="lateral-menu">
                <ul>
                    <li><a href="home.jsp">Inicio</a></li>
                    <li><a href="publicar.jsp">Publicar Tarea</a></li>
                    <li><a href="revisar.jsp">Revisar Tareas</a></li>
                    <li><a href="rubricas.jsp">Rubricas</a></li>
                    <li><a href="misalumnos.jsp">Mis alumnos</a></li>
                    <li><a href="estadisticas.jsp">Estadísticas</a></li>
                    <li><a href="salir.jsp">Salir</a></li>
                </ul>
            </nav>
        </header>
        <section id="main">
            <form id="form-tareas-grupo">
                <select id="filtro-grupo" name="filtro-grupo">
                    <option value="Grupo1">Grupo1</option>
                    <option value="Grupo2">Grupo2</option>
                </select>
            </form>
            <section id="tareas-grupo-pendientes">
                <h2>Pendientes por calificar</h2>
                <article class="tarea pendiente" id="tarea-231sqsdewq987ab">
                    <div id="titulo-tarea">{{titulo_tarea}}</div>
                    <div id="nombre-alumno-tarea">{{nombre_alumno_tarea}}</div>
                    <div id="grupo-alumno-tarea">{{grupo_alumno_tarea}}</div>
                    <div id="contenido-tarea">{{contenido_tarea}}</div>
                    <div id="fecha-entrega-tarea">{{fecha_entrega_tarea}}</div>
                    <div id="fecha-entregada-tarea">{{fecha_entregada_tarea}}</div>
                    <div id="desplazar-comentarios-tarea"><a href="revisar.jsp?mostrar_comentarios=true&id_tarea=231sqsdewq987ab">Mostrar Comentarios</a></div>
                </article>
                
            </section>
            <section id="tareas-grupo-atrasadas">
                <h2>Atrasadas</h2>
                <article class="tarea atrasada" id="tarea-231sqsdewq98sab">
                    <div id="titulo-tarea-atrasada">{{titulo_tarea}}</div>
                    <div id="nombre-alumno-tarea-atrasada">{{nombre_alumno_tarea}}</div>
                    <div id="grupo-alumno-tarea-atrasada">{{grupo_alumno_tarea}}</div>
                    <div id="contenido-tarea-atrasada">{{contenido_tarea}}</div>
                    <div id="fecha-entrega-tarea-atrasada">{{fecha_entrega_tarea}}</div>
                    <div id="fecha-entregada-tarea-atrasada">{{fecha_entregada_tarea}}</div>
                    <div id="desplazar-comentarios-tarea-atrasada"><a href="revisar.jsp?mostrar_comentarios=true&id_tarea=231sqsdewq987ab">Mostrar Comentarios</a></div>
                </article>
            </section>
            <section id="tareas-grupo-discusiones">
                <h2>Discusiones</h2>
                <article  class="tarea discusion" id="tarea-231sqsdewq98aab">
                    <div id="titulo-tarea-discusiones">{{titulo_tarea}}</div>
                    <div id="nombre-alumno-tarea-discusiones">{{nombre_alumno_tarea}}</div>
                    <div id="grupo-alumno-tarea-discusiones">{{grupo_alumno_tarea}}</div>
                    <div id="contenido-tarea-discusiones">{{contenido_tarea}}</div>
                    <div id="fecha-entrega-tarea-discusiones">{{fecha_entrega_tarea}}</div>
                    <div id="fecha-entregada-tarea-discusiones">{{fecha_entregada_tarea}}</div>
                    <div id="desplazar-comentarios-tarea-discusiones"><a href="revisar.jsp?mostrar_comentarios=true&id_tarea=231sqsdewq987ab">Mostrar Comentarios</a></div>
                </article>
            </section>
        </section>
    </body>
</html>
