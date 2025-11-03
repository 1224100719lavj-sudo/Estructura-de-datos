package Ejercicio5;

import java.util.Stack;

/**
 *
 * @author jante
 */
public class Balanceo {
     public static boolean estaBalanceada(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char c : expresion.toCharArray()) {
            if (c == '(') pila.push(c);
            else if (c == ')') {
                if (pila.isEmpty()) return false;
                pila.pop();
            }
        }
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        // Pruebas 
        System.out.println("((2+3)*5) -> " + estaBalanceada("((2+3)*5)"));
        System.out.println("((2+3)*5 -> " + estaBalanceada("((2+3)*5"));
    }
}