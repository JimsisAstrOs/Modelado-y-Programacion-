package tests;

import src.TablaHashSondeoLineal;

public class PruebaSondeoLineal {

    public static void main(String[] args) {
        System.out.println("=== Ejecutando pruebas de Sondeo Lineal y DELETED ===");

        TablaHashSondeoLineal<Integer, String> tabla = new TablaHashSondeoLineal<>(5);

        tabla.insertar(5, "Cinco");
        tabla.insertar(10, "Diez");

        System.out.println("Inserción inicial exitosa.");

        boolean borrado = tabla.eliminar(5);
        System.out.println("¿Se borró la clave 5?: " + borrado);

        String busquedaBorrado = tabla.buscar(5);
        System.out.println("Búsqueda de clave 5 (debe ser null): " + busquedaBorrado);

        String busquedaSiguiente = tabla.buscar(10);
        System.out.println("Búsqueda de clave 10 tras borrado (debe ser 'Diez'): " + busquedaSiguiente);

        if (busquedaBorrado == null && "Diez".equals(busquedaSiguiente)) {
            System.out.println("\n¡PRUEBA SUPERADA! El centinela DELETED funciona correctamente.");
        } else {
            System.out.println("\nPRUEBA FALLIDA. Revisa la lógica de saltos en DELETED.");
        }
    }
}