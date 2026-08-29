import java.util.Scanner;

public class Calif {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nombre;
        double cal1, cal2, cal3, promedio;

        while (true) {

            System.out.print("Nombre del estudiante: ");
            nombre = sc.nextLine();

            boolean valido = true;

            if (nombre.trim().isEmpty()) {

                valido = false;
                System.out.println("El nombre no puede estar vacío.");

            } else {

                
                for (int i = 0; i < nombre.length(); i++) {

                    char caracter = nombre.charAt(i);

                    if (!Character.isLetter(caracter) && caracter != ' ') {

                        valido = false;
                        break;
                    }
                }

                if (!valido) {
                    System.out.println(
                        "Error: el nombre solo puede contener letras y espacios."
                    );
                }
            }

            if (valido) {
                break;
            }
        }

        // Primera 
        while (true) {

            try {

                System.out.print("Primera calificación: ");
                cal1 = Double.parseDouble(sc.nextLine());

                if (cal1 >= 0 && cal1 <= 10) {
                    break;
                }

                System.out.println(
                    "La calificación debe estar entre 0 y 10."
                );

            } catch (Exception e) {

                System.out.println("Ingresa un número válido.");
            }
        }

        // Segunda 
        while (true) {

            try {

                System.out.print("Segunda calificación: ");
                cal2 = Double.parseDouble(sc.nextLine());

                if (cal2 >= 0 && cal2 <= 10) {
                    break;
                }

                System.out.println(
                    "La calificación debe estar entre 0 y 10."
                );

            } catch (Exception e) {

                System.out.println("Ingresa un número válido.");
            }
        }

        // Tercera 
        while (true) {

            try {

                System.out.print("Tercera calificación: ");
                cal3 = Double.parseDouble(sc.nextLine());

                if (cal3 >= 0 && cal3 <= 10) {
                    break;
                }

                System.out.println(
                    "La calificación debe estar entre 0 y 10."
                );

            } catch (Exception e) {

                System.out.println("Ingresa un número válido.");
            }
        }

        // promedio
        promedio = (cal1 + cal2 + cal3) / 3;

        System.out.println("\n- RESULTADO -");
        System.out.println("Estudiante: " + nombre);
        System.out.printf("Promedio: %.2f%n", promedio);

        if (promedio >= 6) {

            System.out.println("Estado académico: APROBADO");

        } else {

            System.out.println("Estado académico: REPROBADO");
        }

        sc.close();
    }
}