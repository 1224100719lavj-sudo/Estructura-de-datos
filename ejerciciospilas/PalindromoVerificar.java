package ejercicio10;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author jante
 */
public class PalindromoVerificar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();

        Stack<Character> pila = new Stack<>();

        // Apilar los caracteres
        for (char c : palabra.toCharArray()) {
            pila.push(c);
        }

        // Crear versión invertida
        String invertida = "";
        while (!pila.isEmpty()) {
            invertida += pila.pop();
        }

        // Verificar si son iguales
        if (palabra.equalsIgnoreCase(invertida)) {
            System.out.println("La palabra '" + palabra + "' es palindroma.");
        } else {
            System.out.println("La palabra '" + palabra + "' no es palindroma.");
        }
    }
}
