package Ejercicio6;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author jante
 */
public class ConvertirDecimalBinario {
      public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese un numero : ");
        int numero = entrada.nextInt();

        Stack<Integer> pilaBinario = new Stack<>();
        int temp = numero;

        // Guardamos los restos 
        while (temp > 0) {
            pilaBinario.push(temp % 2);
            temp /= 2;
        }

        // Desapilamos para mostrar el binario
        System.out.print("El numero " + numero + " en binario es: ");
        while (!pilaBinario.isEmpty()) {
            System.out.print(pilaBinario.pop());
        }
        System.out.println();
    }
}
