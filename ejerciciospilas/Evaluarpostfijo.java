package ejercicio8;

import java.util.Stack;

/**
 *
 * @author jante
 */

    public class Evaluarpostfijo {

    // Método que realiza la evaluación
    public static int evaluarExpresion(String expresion) {
        Stack<Integer> pila = new Stack<>();
        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) { // si es número
                pila.push(Integer.valueOf(token));
            } else { // operador
                int b = pila.pop();
                int a = pila.pop();

                switch (token) {
                    case "+" -> pila.push(a + b);
                    case "-" -> pila.push(a - b);
                    case "*" -> pila.push(a * b);
                    case "/" -> pila.push(a / b);
                    default -> throw new IllegalArgumentException("Operador no reconocido: " + token);
                }
            }
        }
        return pila.pop();
    }

    public static void main(String[] args) {
        String expr = "5 3 + 8 2 - *";
        int resultado = evaluarExpresion(expr);
        System.out.println("Resultado de '" + expr + "': " + resultado);
    }
}