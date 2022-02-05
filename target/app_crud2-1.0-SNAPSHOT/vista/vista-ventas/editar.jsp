<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Actualizar Ventas</title>
</head>
<body>
<h1>Actualizar Ventas</h1>
<form action="adminVentas?action=editar" method="post" >
    <table>
        <tr>
            <td><label>Id_venta</label></td>
            <td><input type="text" name="id_venta" value="<c:out value="${ventas.id_venta}"></c:out>" ></td>
        </tr>
        <tr>
            <td><label>Nombre_articulo</label></td>
            <td><input type="text" name="nombre_articulo" value='<c:out value="${ventas.nombre_articulo}"></c:out>' ></td>
        </tr>
        <tr>
            <td><label>Cantidad</label></td>
            <td><input type="text" name="cantidad" value='<c:out value="${ventas.cantidad }"></c:out>' ></td>
        </tr>
        <tr>
            <td><label>Valor_unitario</label></td>
            <td><input type="text" name="valor_unitario" value='<c:out value="${ventas.valor_unitario }"></c:out>' ></td>
        </tr>

        <tr>
            <td><label>Precio_total</label></td>
            <td><input type="text" name="precio_total" value='<c:out value="${ventas.precio_total }"></c:out>' ></td>
        </tr>
    </table>

    <input type="submit" name="registrar" value="Guardar">
</form>

</body>
</html>