<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.TblUsuariocl3"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Actualizar Usuario</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Actualizar Usuario</h1>
<form method="post" action="ControladorUsuario">
<% 
    String cod = (request.getAttribute("codigo") != null) ? request.getAttribute("codigo").toString() : "";
    String usu = (request.getAttribute("nombre") != null) ? request.getAttribute("nombre").toString() : "";
    String pas = (request.getAttribute("password") != null) ? request.getAttribute("password").toString() : "";
%>
    <table align="center" border="2">
        <input type="hidden" name="idusuariocl3" value="<%=cod%>">
        <tr>
            <td>Nombre</td>
            <td>
                <input type="text" name="usuariocl3" value="<%=usu%>">
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <input type="text" name="passwordcl3" value="<%=pas%>">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Actualizar Usuario">
            </td>
        </tr>
    </table>
</form>
</body>
</html>