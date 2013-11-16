<%-- 
    Document   : index
    Created on : 01-nov-2013, 1:02:33
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
<title>Inicio</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="" />
<link rel="shortcut icon" href="../favicon.ico"> 
<link href="css/estilo.css" rel="stylesheet">
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/main.js" type="text/javascript"></script>
    </head>
    <body>
<form action="Login" method="post" id="flogin">
    <h1>Hola</h1>
    <input type="text" placeholder="Usuario" name="usuario"/> 
    <input type="password" placeholder="Contraseña" name="password"/>
    <input type="submit" value="Entrar" name="enviar" id="login"/>
    <!--<button id="login" onclick="valida_envia()" >Entrar</button>-->
    <a href="registroprof.jsp" id="profform">Registro de Profesores</a>
</form>  


<aside>
  <h3>Mail</h3>
  <ul>
    <li class="active">Compose</li>
    <li>Inbox <span>14</span></li>
    <li>Draft</li>
    <li>Sent</li>
    <li>Trash</li>
    <li>Junk Mail</li>
  </ul>
</aside> 
<div class="email-details">
  <div><label for="">To:</label><input type="text" />
  </div>
  <div>
  <label for="">Subject:</label><input type="text" />
  </div>
</div>

<section>
  <ul>
    <li class="icon-bold"></li>
    <li class="icon-italic"></li>
    <li class="icon-underline"></li> 
    <li class="icon-paste"></li>
    <li class="icon-paper-clip"></li>
    
  </ul>
  
  <textarea></textarea> 
  
  <button>Send</button>
</section>
</body>
</html>
