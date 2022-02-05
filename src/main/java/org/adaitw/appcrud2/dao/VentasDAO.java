package org.adaitw.appcrud2.dao;

import org.adaitw.appcrud2.model.Conexion;
import org.adaitw.appcrud2.model.Ventas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {
    private static Conexion con;
    private static Connection connection;

    public VentasDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // insertar artículo
    public boolean insertar(Ventas ventas) throws SQLException {
        String sql = "INSERT INTO ventas (id_venta, nombre_articulo, cantidad, valor_unitario, precio_total) VALUES (?, ?, ?,?,?,?)";
        System.out.println(ventas.getNombre_articulo());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, ventas.getNombre_articulo());
        statement.setDouble(3, ventas.getCantidad());
        statement.setDouble(4, ventas.getValor_unitario());
        statement.setDouble(5, ventas.getPrecio_total());


        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar todos los productos
    public List<Ventas> listarVentas() throws SQLException {

        List<Ventas> listaVentas = new ArrayList<Ventas>();
        String sql = "SELECT * FROM ventas";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int id_venta = resulSet.getInt("id_venta");
            String nombre_articulo = resulSet.getString("nombre_articulo");
            Double cantidad = resulSet.getDouble("cantidad");
            Double valor_unitario = resulSet.getDouble("valor_unitario");
            Double precio_total = resulSet.getDouble("precio_total");
            Ventas ventas = new Ventas(id_venta, nombre_articulo, cantidad, valor_unitario, precio_total);
            listaVentas.add(ventas);
        }
        con.desconectar();
        return listaVentas;
    }

    // obtener por id
    public Ventas obtenerPorId_venta(int id_venta) throws SQLException {
        Ventas ventas = null;

        String sql = "SELECT * FROM ventas WHERE id_venta= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_venta);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            ventas = new Ventas(res.getInt("id_venta"), res.getString("nombre_articulo"),
                     res.getDouble("cantidad"), res.getDouble("valor_unitario"),
                     res.getDouble("precio_total"));
        }
        res.close();
        con.desconectar();

        return ventas;
    }

    // actualizar
    public boolean actualizar(Ventas ventas) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE ventas SET id_venta=?,nombre_articulo=?,cantidad=?,valor_unitario=?, precio_total=? WHERE id_venta=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ventas.getId_venta());
        statement.setString(2, ventas.getNombre_articulo());
        statement.setDouble(3, ventas.getCantidad());
        statement.setDouble(4, ventas.getValor_unitario());
        statement.setDouble(5, ventas.getPrecio_total());
        System.out.println(ventas.getPrecio_total());
        statement.setDouble(5, ventas.getPrecio_total());
        statement.setInt(6, ventas.getId_venta());

        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowActualizar;

    }

    //eliminar
    public boolean eliminar(Ventas ventas) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM Ventas WHERE ID_venta=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ventas.getId_venta());

        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();

        return rowEliminar;
    }
}
