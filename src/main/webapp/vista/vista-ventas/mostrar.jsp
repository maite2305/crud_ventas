<%--
  Created by IntelliJ IDEA.
  User: MAITE
  Date: 31/01/2022
  Time: 7:31 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Administrar Ventas</title>
</head>
<body>
<h1>Lista  Ventas</h1>
<table>
    <tr>
        <td><a href="adminVentas?action=index" >Ir al menú</a> </td>
    </tr>
</table>

<table border="1" width="100%">
    <tr>
        <td>ID_venta</td>
        <td>NOMBRE_ARTICULO</td>
        <td>CANTIDAD</td>
        <td>VALOR_UNITARIO</td>
        <td>PRECIO_TOTAL</td>
        <td colspan=2>ACCIONES</td>
    </tr>
    <c:forEach var="ventas" items="${lista}">
        <tr>
            <td><c:out value="${ventas.id_venta}"/></td>
            <td><c:out value="${ventas.nombre_articulo}"/></td>
            <td><c:out value="${ventas.cantidad}"/></td>
            <td><c:out value="${ventas.valor_unitario}"/></td>
            <td><c:out value="${ventas.precio_total}"/></td>
            <td><a href="adminVentas?action=showedit&id_venta=<c:out value="${ventas.id_venta}" />">Editar</a></td>
            <td><a href="adminVentas?action=eliminar&id_venta=<c:out value="${ventas.id_venta}"/>">Eliminar</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>