<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.TblProductocl3" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Producto</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Listado de Producto Registrados en la BD</h1>
<h2 align="center">
    <a href="FormRegistrarProducto.jsp" style="text-decoration:none; color:blue;">Registrar</a>
</h2>
<table border="2" align="center">
<tr>
<td>Código</td>
<td>Producto</td>
<td>Precio Compra</td>
<td>Precio Venta</td>
<td>Estado</td>
<td>Descripción</td>
<td>Acciones</td>
</tr>
<%
    List<TblProductocl3> listadoproducto = (List<TblProductocl3>) request.getAttribute("listadoproductos");
    if (listadoproducto != null) {
        // Aplicamos un bucle for...
        for (TblProductocl3 lis : listadoproducto) {
%>
<tr>
    <td><%= lis.getIdproductoscl3() %></td>
    <td><%= lis.getNombrecl3() %></td>
    <td><%= lis.getPreciocompcl3() %></td>
    <td><%= lis.getPrecioventacl3() %></td>
    <td><%= lis.getEstadocl3() %></td>
    <td><%= lis.getDescripcl3() %></td>
    <td>
        <a href="ControladorProducto?accion=Eliminar&cod=<%= lis.getIdproductoscl3() %>">Eliminar</a>
        |
        <a href="ControladorProducto?accion=Modificar&cod=<%= lis.getIdproductoscl3() %>">Actualizar</a>
    </td>
</tr>
<%
        } // fin del bucle for...
    } else {
%>
<tr>
    <td colspan="7" align="center">No hay productos registrados</td>
</tr>
<%
    } // fin de la condición...
%>
</table> 
</body>
</html>
