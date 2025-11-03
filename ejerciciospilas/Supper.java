package Ejercicio2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author jante
 */
public class Supper {
    private static final int TOTAL_CARRITOS = 255;
    private static final int TOTAL_CAJAS = 30;
    private static final int TOTAL_CLIENTES = 400;

    public static void main(String[] args) {
        Queue<Integer> carritos = new LinkedList<>();
        for (int i = 1; i <= TOTAL_CARRITOS; i++) {
            carritos.add(i);
        }

        // Cada caja tiene su cola 
        Queue<String>[] cajas = new Queue[TOTAL_CAJAS];
        for (int i = 0; i < TOTAL_CAJAS; i++) {
            cajas[i] = new LinkedList<>();
        }

        Random random = new Random();

        for (int cliente = 1; cliente <= TOTAL_CLIENTES; cliente++) {
            System.out.println("\nCliente " + cliente + " llega al supermercado...");

            // Espera si no hay carritos
            if (carritos.isEmpty()) {
                System.out.println("→ No hay carritos disponibles, cliente " + cliente + " espera.");
                continue;
            }

            // Toma un carrito
            int carrito = carritos.poll();
            System.out.println("→ Cliente " + cliente + " toma el carrito #" + carrito);

            // Busca la caja con menos clientes
            int indiceCaja = 0;
            for (int i = 1; i < TOTAL_CAJAS; i++) {
                if (cajas[i].size() < cajas[indiceCaja].size()) {
                    indiceCaja = i;
                }
            }

            // Se forma en esa caja
            cajas[indiceCaja].add("Cliente " + cliente);
            System.out.println("→ Cliente " + cliente + " se forma en la caja " + (indiceCaja + 1));

            // Aleatoriamente algunos clientes terminan y liberan su carrito
            if (random.nextInt(3) == 0 && !cajas[indiceCaja].isEmpty()) {
                String atendido = cajas[indiceCaja].poll();
                carritos.add(carrito);
                System.out.println("✔ " + atendido + " paga y deja tu carrito #" + carrito);
            }
        }

        // Mostrar resumen
        System.out.println("\n=== Estado final  ===");
        for (int i = 0; i < TOTAL_CAJAS; i++) {
            System.out.println("Caja " + (i + 1) + ": " + cajas[i]);
        }
        System.out.println("Carritos libres: " + carritos.size());
    }
}
