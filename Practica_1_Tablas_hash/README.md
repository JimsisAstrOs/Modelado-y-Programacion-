# Practica 1

# Ejecución

Abre tu terminal en la raíz de la práctica (`practica-1-hash-table/`) y ejecuta los comandos según tu preferencia:

## Opción 1: Compilar y ejecutar desde la raíz del proyecto 

1. Compilar la implementación y las pruebas al mismo tiempo:
   ```bash
   javac src/TablaHash.java tests/PruebasTablaHash.java

Ejecutar el programa principal de pruebas

# Windows
java -cp "src;tests" PruebasTablaHash

# Linux / macOS
java -cp "src;tests" PruebasTablaHash

## Opción 2: Compilar y ejecutar entrando a las carpetas

1.Entar a la carpeta src/ y compilar la clase base
    cd src
    javac TablaHash.java
    cd ...
2.Entrar a la carpeta tests/ , compilar y ejecutar haciendo referencia a src/:
         cd tests
         javac -cp ../src PuebasTablaHash.java
         java -cp #.;../src" PuebasTablaHash

# Tabla Hash

Implementación de una tabla hash en Java utilizando **encadenamiento** para manejar las colisiones.

## Descripción

El programa implementa una tabla hash de tamaño `m = 7`, utilizando una `LinkedList` en cada posición de la tabla para almacenar las entradas que tengan la misma posición hash. Se ejecutan 6 pruebas que muestran el funcionamiento de cada método de la clase `TablaHash`, como insersión, eliminación y búsqueda de elementos.

Cada entrada está formada por:

- `key`: llave entera utilizada para realizar la búsqueda.
- `value`: valor asociado a la llave.

La función hash utilizada es:

```text
hash(key) = |key| % 7