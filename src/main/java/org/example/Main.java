package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Crear producto");
            System.out.println("2. Mostrar información de productos");
            System.out.println("3. Vender producto");
            System.out.println("4. Reponer stock");
            System.out.println("5. Aplicar descuento (2%)");
            System.out.println("6. Aumentar precio (6%)");
            System.out.println("7. Calcular valor total en inventario");
            System.out.println("8. Eliminar producto por código");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Código del producto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();

                    double precio;
                    do {
                        System.out.print("Precio del producto: ");
                        precio = scanner.nextDouble();
                        if (precio < 0) System.out.println("El precio no puede ser negativo.");
                    } while (precio < 0);

                    int cantidad;
                    do {
                        System.out.print("Cantidad en stock: ");
                        cantidad = scanner.nextInt();
                        if (cantidad < 0) System.out.println("La cantidad en stock no puede ser negativa.");
                    } while (cantidad < 0);

                    productos.add(new Producto(codigo, nombre, precio, cantidad));
                    System.out.println("Producto agregado correctamente.");
                    break;

                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos en la lista.");
                    } else {
                        for (Producto producto : productos) {
                            producto.mostrarInformacion();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Código del producto a vender: ");
                    String codigoVender = scanner.next();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoVender)) {
                            System.out.print("Cantidad a vender: ");
                            int cantidadVender = scanner.nextInt();
                            producto.vender(cantidadVender);
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Código del producto a reponer: ");
                    String codigoReponer = scanner.next();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoReponer)) {
                            System.out.print("Cantidad a reponer: ");
                            int cantidadReponer = scanner.nextInt();
                            producto.reponerStock(cantidadReponer);
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.print("Código del producto para aplicar descuento: ");
                    String codigoDescuento = scanner.next();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoDescuento)) {
                            producto.aplicarDescuento(2);
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.print("Código del producto para aumentar precio: ");
                    String codigoAumento = scanner.next();
                    for (Producto producto : productos) {
                        if (producto.getCodigo().equals(codigoAumento)) {
                            producto.aumentarPrecio(6);
                            break;
                        }
                    }
                    break;

                case 7:
                    double totalInventario = 0;
                    for (Producto producto : productos) {
                        totalInventario += producto.calcularValorTotalEnInventario();
                    }
                    System.out.println("El valor total del inventario es: $" + totalInventario);
                    break;

                case 8:
                    System.out.print("Código del producto a eliminar: ");
                    String codigoEliminar = scanner.next();
                    productos.removeIf(producto -> producto.getCodigo().equals(codigoEliminar));
                    System.out.println("Producto eliminado.");
                    break;

                case 9:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
