package src;

public class TablaHashSondeoLineal<K, V> {

    private static class Entrada<K, V> {
        K clave;
        V valor;

        Entrada(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    private final int capacidad;
    private Entrada<K, V>[] tabla;
    
    @SuppressWarnings("unchecked")
    private final Entrada<K, V> DELETED = new Entrada<>(null, null);

    @SuppressWarnings("unchecked")
    public TablaHashSondeoLineal(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = (Entrada<K, V>[]) new Entrada[capacidad];
    }

    private int hashBase(K clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    public void insertar(K clave, V valor) {
        int base = hashBase(clave);

        for (int i = 0; i < capacidad; i++) {
            int indice = (base + i) % capacidad;

            if (tabla[indice] == null || tabla[indice] == DELETED) {
                tabla[indice] = new Entrada<>(clave, valor);
                return;
            }

            if (tabla[indice].clave != null && tabla[indice].clave.equals(clave)) {
                tabla[indice].valor = valor;
                return;
            }
        }
        throw new IllegalStateException("La tabla hash está llena");
    }

    public V buscar(K clave) {
        int base = hashBase(clave);

        for (int i = 0; i < capacidad; i++) {
            int indice = (base + i) % capacidad;

            if (tabla[indice] == null) {
                return null;
            }

            if (tabla[indice] != DELETED && tabla[indice].clave.equals(clave)) {
                return tabla[indice].valor;
            }
        }
        return null;
    }


    public boolean eliminar(K clave) {
        int base = hashBase(clave);

        for (int i = 0; i < capacidad; i++) {
            int indice = (base + i) % capacidad;

            if (tabla[indice] == null) {
                return false; // No se encontró
            }

            if (tabla[indice] != DELETED && tabla[indice].clave.equals(clave)) {
                // Se coloca la marca DELETED en lugar de null
                tabla[indice] = DELETED;
                return true;
            }
        }
        return false;
    }
}