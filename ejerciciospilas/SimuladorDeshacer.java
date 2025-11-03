package Ejercicio7;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author jante
 */
public class SimuladorDeshacer {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> acciones = new Stack<>();

        System.out.println("Simulacion de funcion 'Deshacer' (escriba UNDO o FIN):");

        while (true) {
            System.out.print("> ");
            String accion = sc.nextLine();

            if (accion.equalsIgnoreCase("FIN")) break;

            if (accion.equalsIgnoreCase("UNDO")) {
                if (!acciones.isEmpty()) {
                    System.out.println("Deshaciendo: " + acciones.pop());
                } else {
                    System.out.println("No hay acciones para deshacer.");
                }
            } else {
                acciones.push(accion);
                System.out.println("Accion guardada: " + accion);
            }

            System.out.println("Estado actual de la pila: " + acciones);
        }
    }
}
