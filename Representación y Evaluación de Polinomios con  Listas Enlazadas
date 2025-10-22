package listaPolinomios;

import java.util.Scanner;

public class PolinomioLista {

    static class Nodo {
        double coeficiente;
        int exponente;
        Nodo siguiente;

        public Nodo(double coef, int exp) {
            this.coeficiente = coef;
            this.exponente = exp;
            this.siguiente = null;
        }
    }

    static class ListaEnlazadaPolinomio {
        private Nodo cabeza;

        public ListaEnlazadaPolinomio() {
            cabeza = null;
        }

        public void insertarTermino(double coeficiente, int exponente) {
            Nodo nuevo = new Nodo(coeficiente, exponente);
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }

        public double evaluar(double x) {
            double resultado = 0.0;
            Nodo actual = cabeza;
            while (actual != null) {
                resultado += actual.coeficiente * Math.pow(x, actual.exponente);
                actual = actual.siguiente;
            }
            return resultado;
        }

        public void mostrarPolinomio() {
            if (cabeza == null) {
                System.out.println(" El polinomio está vacío.");
                return;
            }
            Nodo actual = cabeza;
            System.out.print("P(x) = ");
            while (actual != null) {
                double coef = actual.coeficiente;
                int exp = actual.exponente;
                if (coef >= 0 && actual != cabeza) System.out.print("+ ");
                System.out.print(coef);
                if (exp > 0) System.out.print("x^" + exp + " ");
                else System.out.print(" ");
                actual = actual.siguiente;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazadaPolinomio polinomio = new ListaEnlazadaPolinomio();

        
        System.out.println("==============================================");
        System.out.println("Ingrese los términos del polinomio (coeficiente y exponente).");
        System.out.println("Ejemplo: 3 4  -4 2  11 0 representa 3x^4 - 4x^2 + 11");
        System.out.println("Cuando termine, escriba 'fin'.");

        while (true) {
            System.out.print("Coeficiente (o 'fin'): ");
            String entrada = sc.next();
            if (entrada.equalsIgnoreCase("fin")) break;
            try {
                double coef = Double.parseDouble(entrada);
                System.out.print("Exponente: ");
                int exp = sc.nextInt();
                polinomio.insertarTermino(coef, exp);
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Intente nuevamente.");
            }
        }

        System.out.println("\n📋 Polinomio ingresado:");
        polinomio.mostrarPolinomio();

        System.out.println("\n Evaluación del Polinomio");
        System.out.println("-------------------------------");
        System.out.printf("%6s | %10s\n", "x", "P(x)");
        System.out.println("-------------------------------");

        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double resultado = polinomio.evaluar(x);
            System.out.printf("%6.2f | %10.4f\n", x, resultado);
        }

        System.out.println("-------------------------------");
        System.out.println(" Evaluación completada con éxito.");
        sc.close();
    }
}
