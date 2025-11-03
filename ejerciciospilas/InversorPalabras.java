package ejercicio4;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author jante
 */
public class InversorPalabras {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una palabra: ");
        String palabra = sc.nextLine();

        Stack<Character> pila = new Stack<>();

        // Apilar cada letra
        for (char c : palabra.toCharArray()) {
            pila.push(c);
        }

        // Desapilar para invertir
        System.out.print("Palabra invertida: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop());
        }
        System.out.println();
    }
}
