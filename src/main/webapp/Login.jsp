<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/Login.css">
    <title>Login y Registro</title>
    <style type="text/css">
        body {
            background-image: url('imagenes/log.jpg'); /* URL de tu imagen de fondo */
            background-position: center;
            background-size: cover;
            background-repeat: no-repeat;
            height: 100vh;
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
    <div class="contenedor">
        <div class="container-page" id="Container">
            <div class="login-container" id="LoginContainer">
                <h1 class="title">Iniciar Sesión</h1>
                <form method="post" action="LoginServlet">
                    <div class="input-line-container">
                        <span class="name-input">Usuario</span>
                        <input type="text" name="usuario" class="input-line" required>
                    </div>
                    <div class="input-line-container">
                        <span class="name-input">Contraseña</span>
                        <input type="password" name="contraseña" class="input-line" required>
                    </div>
                    <button class="button-login" type="submit">Login</button>
                    <button class="button-second" type="button" onclick="window.location.href = 'FormRegistrarUsuario.jsp';">Registrarse</button>
                </form>
                <%
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if (errorMessage != null) {
                %>
                <div class="error-message" style="color:red; margin-top:10px;">
                    <%= errorMessage %>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="code.js"></script>
</body>
</html>
