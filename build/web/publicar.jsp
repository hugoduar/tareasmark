<%-- 
    Document   : publicar
    Created on : 01-nov-2013, 1:16:22
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicar Tarea</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <h1>Publicar nueva tarea</h1>
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
                        <option value="Grupo1">Grupo1</option>
                        <option value="Grupo2">Grupo2</option>
                    </select>
                    <input type="submit" value="Publicar Tarea"/>
                </form>
            </article>
        </section>
    </body>
</html>
