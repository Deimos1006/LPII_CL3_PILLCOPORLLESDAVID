<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.TblProductocl3"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Actualizar Producto</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Actualizar Producto</h1>
<form method="post" action="ControladorProducto">
<% 
    String cod = (request.getAttribute("codigo") != null) ? request.getAttribute("codigo").toString() : "";
    String nom = (request.getAttribute("nombrecl3") != null) ? request.getAttribute("nombrecl3").toString() : "";
    String prev = (request.getAttribute("precioventacl3") != null) ? request.getAttribute("precioventacl3").toString() : "";
    String prec = (request.getAttribute("preciocompcl3") != null) ? request.getAttribute("preciocompcl3").toString() : "";
    String esta = (request.getAttribute("estadocl3") != null) ? request.getAttribute("estadocl3").toString() : "";
    String des = (request.getAttribute("descripcl3") != null) ? request.getAttribute("descripcl3").toString() : "";
%>
    <table align="center" border="2">
        <input type="hidden" name="idproductocl3" value="<%=cod%>">
        <tr>
            <td>Nombre</td>
            <td>
                <input type="text" name="nombrecl3" value="<%=nom%>">
            </td>
        </tr>
        <tr>
            <td>Precio Venta</td>
            <td>
                <input type="text" name="precioventacl3" value="<%=prev%>">
            </td>
        </tr>
        <tr>
            <td>Precio Compra</td>
            <td>
                <input type="text" name="preciocompcl3" value="<%=prec%>">
            </td>
        </tr>
        <tr>
            <td>Estado</td>
            <td>
                <input type="text" name="estadocl3" value="<%=esta%>">
            </td>
        </tr>
        <tr>
            <td>Descripción</td>
            <td>
                <input type="text" name="descripcl3" value="<%=des%>">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Actualizar Producto">
            </td>
        </tr>
    </table>
</form>
</body>
</html>