package Ejercicio3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author jante
 */
public class SupperHEB {
     private static final int DURACION_SIMULACION = 420; // 7 horas en minutos
    private static final int CLIENTES_POR_MINUTO = 1;
    private static final int TIEMPO_MIN_ATENCION = 3;
    private static final int TIEMPO_MAX_ATENCION = 7;

    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        Random random = new Random();

        int[] cajas = new int[4]; // cuarta caja opcional como el oxxo
        boolean cuartaAbierta = false;

        int clientesAtendidos = 0;
        int maxFila = 0;
        int tiempoAperturaCuarta = -1;

        for (int minuto = 1; minuto <= DURACION_SIMULACION; minuto++) {
            // Llegan  clientes
            int nuevos = CLIENTES_POR_MINUTO;
            for (int i = 0; i < nuevos; i++) {
                fila.add(minuto);
            }

            if (fila.size() > 20 && !cuartaAbierta) {
                cuartaAbierta = true;
                tiempoAperturaCuarta = minuto;
                System.out.println("chance se abre la cuarta caja en el minuto " + minuto);
            }

            // Atender clientes
            for (int i = 0; i < (cuartaAbierta ? 4 : 3); i++) {
                if (cajas[i] == 0 && !fila.isEmpty()) {
                    fila.poll();
                    cajas[i] = random.nextInt(TIEMPO_MAX_ATENCION - TIEMPO_MIN_ATENCION + 1) + TIEMPO_MIN_ATENCION;
                    clientesAtendidos++;
                } else if (cajas[i] > 0) {
                    cajas[i]--;
                }
            }
