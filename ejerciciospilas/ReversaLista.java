package ejercicio9;

import java.util.Stack;

/**
 *
 * @author jante
 */
public class ReversaLista {
    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4};
        Stack<Integer> pila = new Stack<>();

        // Apilamos los elementos
        for (int numero : lista) {
            pila.push(numero);
        }

        // Desapilamos e imprimimos para mostrar el orden inverso
        System.out.print("Lista invertida: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop() + " ");
        }
        System.out.println();
    }
}
