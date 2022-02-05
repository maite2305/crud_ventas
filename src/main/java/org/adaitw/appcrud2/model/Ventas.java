package org.adaitw.appcrud2.model;

public class Ventas {

    private int id_venta;
    private String nombre_articulo;
    private double cantidad;
    private double valor_unitario;
    private double precio_total;

    public Ventas(int id_venta, String nombre_articulo, double cantidad, double valor_unitario, double precio_total) {
        this.id_venta = id_venta;
        this.nombre_articulo = nombre_articulo;
        this.cantidad = cantidad;
        this.valor_unitario = valor_unitario;
        this.precio_total = precio_total;
    }
    //getters y setters

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }
}
