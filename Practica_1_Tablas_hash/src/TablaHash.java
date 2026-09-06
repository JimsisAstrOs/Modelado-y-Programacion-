import java.util.LinkedList;

class Entrada {
    int key;
    String value;

    public Entrada(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class TablaHash {
    
    private final int m = 7;
    private final LinkedList<Entrada>[] tabla;
    private int n;

    @SuppressWarnings("unchecked")
    public TablaHash() {
        this.tabla = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            this.tabla[i] = new LinkedList<>();
        }
        this.n = 0;
    }

    private int hash(int key) {
        return Math.abs(key) % m;
    }

    public double factorCarga() {
        return (double) n / m;
    }

    public void insertar(int key, String value) {
        int posicion = hash(key);
        LinkedList<Entrada> cubeta = tabla[posicion];
        for (Entrada par : cubeta) {
            if (par.key == key) {
                par.value = value;
                return;
            }
        }
        cubeta.add(new Entrada(key, value));
        n++;
    }

    public String buscar(int key) {
        int posicion = hash(key);
        LinkedList<Entrada> cubeta = tabla[posicion];
        for (Entrada par : cubeta) {
            if (par.key == key) {
                return par.value;
            }
        }
        System.out.println("No se encontró el elemento buscado :(");
        return null;
    }

    public boolean eliminar(int key) {
        int posicion = hash(key);
        LinkedList<Entrada> cubeta = tabla[posicion];
        for (int i = 0; i < cubeta.size(); i++) {
            if (cubeta.get(i).key == key) {
                cubeta.remove(i);
                n--;
                System.out.println("Elemento eliminado con éxito :)");
                return true;
            }
        }
        System.out.println("Erroooooor, no se encontró el elemento :(");
        return false;
    }

    public void imprimirTabla() {
        System.out.println("------TablaHash------");
        for (int i = 0; i < m; i++) {
            System.out.print("[" + i + "] ----> ");
            LinkedList<Entrada> cubeta = tabla[i];
            if (cubeta.isEmpty()) {
                System.out.println("Está vacíoooo :O");
            } else {
                for (int j = 0; j < cubeta.size(); j++) {
                    Entrada par = cubeta.get(j);
                    System.out.print("(" + par.key + ",\"" + par.value + "\")");
                    if (j < cubeta.size() - 1) {
                        System.out.print("-->");
                    }
                }
                System.out.println();
            }
        }
        System.out.println("Factor de Carga (alpha): " + factorCarga());
        System.out.println("-----------------------");
    }
}