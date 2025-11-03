package Ejercicio1;

/**
 *
 * @author jante
 */

import java.util.Stack;

import java.util.Stack;

public class PilaSimples {

    public static void main(String[] args) {
        // Creamos una pila vacía que almacenará enteros
        Stack<Integer> pilaEnteros = new Stack<>();

        // Insertamos algunos valores
        pilaEnteros.push(5);
        pilaEnteros.push(10);
        pilaEnteros.push(15);
        pilaEnteros.push(20);

        // Eliminamos los dos últimos elementos 
        pilaEnteros.pop(); // elimina 20
        pilaEnteros.pop(); // elimina 15

        // Mostramos el contenido 
        System.out.println("Contenido actual de la pila: " + pilaEnteros);
    }
}
