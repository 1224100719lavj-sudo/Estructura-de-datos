package ejercicio3;
import java.util.Stack;
/**
 *
 * @author jante
 */
public class VerificarPila {

     public static void main(String[] args) {
        // Crear una pila vacía
        Stack<Integer> pila = new Stack<>();

        // Comprobar si está vacía al inicio
        System.out.println("¿La pila esta vacia? " + pila.isEmpty());

        // Insertar un elemento
        pila.push(7);

        // Comprobar nuevamente
        System.out.println("¿La pila esta vacia ? " + pila.isEmpty());
    }
}