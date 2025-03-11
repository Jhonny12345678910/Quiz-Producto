package org.example;

public class Producto {
    private String codigo;
    private String nombre;
    private int precio;
    private int cantidadEnStock;

    public Producto(String codigo, String nombre, int precio, int cantidadEnStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        setPrecio(precio);
        setCantidadEnStock(cantidadEnStock);
    }

    public void vender(int cantidad) {
        if (cantidad < 0) {
            System.out.println("La cantidad no puede ser negativa.");
            return;
        }
        if (cantidadEnStock >= cantidad) {
            cantidadEnStock -= cantidad;
            System.out.println("Se vendieron " + cantidad + " unidades de " + nombre);
        } else {
            System.out.println("No hay suficiente stock para vender " + cantidad + " unidades.");
        }
    }

    public void reponerStock(int cantidad) {
        if (cantidad < 0) {
            System.out.println("La cantidad a reponer no puede ser negativa.");
            return;
        }
        cantidadEnStock += cantidad;
        System.out.println("Se repuso el stock de " + nombre + " con " + cantidad + " unidades.");
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje < 0) {
            System.out.println("El porcentaje de descuento no puede ser negativo.");
            return;
        }
        precio *= (1 - porcentaje / 100);
        System.out.println("Se aplicó un descuento del " + porcentaje + "% al precio de " + nombre);
    }

    public void aumentarPrecio(double porcentaje) {
        if (porcentaje < 0) {
            System.out.println("El porcentaje de aumento no puede ser negativo.");
            return;
        }
        precio *= (1 + porcentaje / 100);
        System.out.println("Se aumentó el precio de " + nombre + " en un " + porcentaje + "%.");
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad en stock: " + cantidadEnStock + " unidades");
    }

    public double calcularValorTotalEnInventario() {
        return precio * cantidadEnStock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            System.out.println("El precio no puede ser negativo. Se establecerá en 0.");
            this.precio = 0;
        } else {
            this.precio = (int) precio;
        }
    }

    public void setCantidadEnStock(int cantidad) {
        if (cantidad < 0) {
            System.out.println("La cantidad en stock no puede ser negativa. Se establecerá en 0.");
            this.cantidadEnStock = 0;
        } else {
            this.cantidadEnStock = cantidad;
        }
    }
}
