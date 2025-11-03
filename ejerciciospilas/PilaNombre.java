package Ejercicio2;

/**
 *
 * @author jante
 */
import java.util.Scanner;
import java.util.Stack;

public class PilaNombre {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Stack<String> pilaNombres = new Stack<>();
        String nombre;

        System.out.println("Ingrese nombres (escriba 'FIN' para terminar):");

        // Ciclo que pide nombres hasta que el usuario escriba "FIN"
        while (true) {
            System.out.print("Nombre: ");
            nombre = entrada.nextLine();

            if (nombre.equalsIgnoreCase("FIN")) break;
            pilaNombres.push(nombre);
        }

        // Imprimir los nombres en orden inverso
        System.out.println("\nNombres en orden inverso:");
        while (!pilaNombres.isEmpty()) {
            System.out.println(pilaNombres.pop());
        }
    }
}
