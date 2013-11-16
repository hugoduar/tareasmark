<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Profesores</title>
<link rel="shortcut icon" href="../favicon.ico"> 
<link href="css/estilo.css" rel="stylesheet">
    </head>
    <body>
        <h1>Registro de Profesores</h1>
        
        <div id="dform"> 
        <form id="form">
            <input type="text" placeholder="Nombre" name="nombre"/> 
            <input type="text" placeholder="Apellido Paterno" name="apellidopaterno"/> 
            <input type="text" placeholder="Apellido materno" name="apellidomaterno"/>
            <input type="text" placeholder="RFC" name="rfc"/>
            <input type="text" placeholder="Número de profesor" name="noempleado"/>
            <input type="password" placeholder="Contraseña" name="contra"/> 
            <input type="submit" value="Aceptar" name="Aceptar" id="button"/>
        </form>
        </div>
        
    </body>
</html>
