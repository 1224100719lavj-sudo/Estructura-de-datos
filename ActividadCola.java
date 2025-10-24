package Cola;

/**
 *
 * @author jante
 */
import java.util.Scanner;

public class MainCola {
    public static void main(String[] args) {
        Cola<String> tareas = new Cola<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU DE  TAREAS =====");
            System.out.println("1. Crear y agregar tareas iniciales");
            System.out.println("2. Solicitar tamaño de la cola");
            System.out.println("3. Consultar frente de la cola");
            System.out.println("4. Quitar tarea 1 y mostrar tarea ejecutada");
            System.out.println("5. Quitar tarea 2 y mostrar tarea ejecutada");
            System.out.println("6. Mostrar estado final de la cola");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    
                    tareas.insertar("Preparar café");
                    tareas.insertar("Revisar emails");
                    tareas.insertar("Iniciar proyecto");
                    break;

                case 2:
                    System.out.println(" Tamaño actual de la cola: " + tareas.getTamano());
                    break;

                case 3:
                    String frente = tareas.frente();
                    if (frente != null)
                        System.out.println(" Frente de la cola: " + frente);
                    break;

                case 4:
                    tareas.quitar();
                    break;

                case 5:
                    tareas.quitar();
                    break;

                case 6:
                    tareas.mostrarCola();
                    break;

                case 0:
                    System.out.println(" Saliendo del programa...");
                    break;

                default:
                    System.out.println(" Opción invalida. Intente nuevamente.");
            }

        } while (opcion != 0);

        sc.close();
    }
}


package Cola;

/**
 *
 * @author valencia jantes luis angel 24/10/
 */
public class Nodo<T> {
    private T dato;
    private Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}

package Cola;

/**
 *
 * @author jante
 * @param <T>
 */




public class Cola<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;

    public Cola() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public boolean colaVacia() {
        return cabeza == null;
    }

    public void insertar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (colaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            cola = nuevoNodo;
        }
        tamano++;
        System.out.println(" Insertado: " + elemento);
    }

    public T quitar() {
        if (colaVacia()) {
            System.out.println("️ Error: la cola esta vacía");
            return null;
        }
        T datoQuitado = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        if (cabeza == null) {
            cola = null;
        }
        tamano--;
        System.out.println(" Tarea ejecutada: " + datoQuitado);
        return datoQuitado;
    }

    public T frente() {
        if (colaVacia()) {
            System.out.println("️ Error: la cola está vacía");
            return null;
        }
        return cabeza.getDato();
    }

    public int getTamano() {
        return tamano;
    }

    public void mostrarCola() {
        if (colaVacia()) {
            System.out.println("️ La cola está vacía.");
            return;
        }
        Nodo<T> actual = cabeza;
        System.out.println(" Estado actual de la cola:");
        while (actual != null) {
            System.out.println("- " + actual.getDato());
            actual = actual.getSiguiente();
        }
    }
}
