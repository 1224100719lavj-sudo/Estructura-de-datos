/**
 *
 * @author jante
 */
public class CompararColas {
     public static <T> boolean sonIguales(Queue<T> colaA, Queue<T> colaB) {
        if (colaA.size() != colaB.size()) {
            return false;
        }

        Queue<T> auxA = new LinkedList<>();
        Queue<T> auxB = new LinkedList<>();
        boolean iguales = true;

        while (!colaA.isEmpty() && !colaB.isEmpty()) {
            T elemA = colaA.remove();
            T elemB = colaB.remove();

            if (!elemA.equals(elemB)) {
                iguales = false;
            }

            auxA.add(elemA);
            auxB.add(elemB);
        }

        // restaurar las colas
        colaA.addAll(auxA);
        colaB.addAll(auxB);

        return iguales;
    }

    //  probar  funcionamiento
    public static void main(String[] args) {
        Queue<Integer> cola1 = new LinkedList<>();
        Queue<Integer> cola2 = new LinkedList<>();

        // Agregamos datos
        for (int i = 1; i <= 5; i++) {
            cola1.add(i);
            cola2.add(i);
        }

        System.out.println("Cola 1: " + cola1);
        System.out.println("Cola 2: " + cola2);
        System.out.println("Son iguales? " + sonIguales(cola1, cola2));

        // Se modifica una cola para probar la diferencia
        cola2.poll();
        cola2.add(9);

        System.out.println("\nCola 1: " + cola1);
        System.out.println("Cola 2: " + cola2);
        System.out.println("Son iguales ahora? " + sonIguales(cola1, cola2));
    }
}