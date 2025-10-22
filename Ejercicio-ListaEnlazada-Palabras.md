package listaPalabras;

import java.io.*;
import java.util.Scanner;



public class ListaPalabras {

    
    static class Nodo {
        String palabra;
        Nodo siguiente;

        public Nodo(String palabra) {
            this.palabra = palabra;
            this.siguiente = null;
        }
    }

   
    static class ListaEnlazada {
        private Nodo cabeza;

        public ListaEnlazada() {
            cabeza = null;
        }

      
        public void insertar(String palabra) {
            Nodo nuevo = new Nodo(palabra);
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

       
        public boolean eliminar(String palabra) {
            if (cabeza == null) return false;

            if (cabeza.palabra.equals(palabra)) {
                cabeza = cabeza.siguiente;
                return true;
            }

            Nodo actual = cabeza;
            while (actual.siguiente != null && !actual.siguiente.palabra.equals(palabra)) {
                actual = actual.siguiente;
            }

            if (actual.siguiente != null) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            return false;
        }

        
        public void mostrar() {
            Nodo actual = cabeza;
            if (actual == null) {
                System.out.println("(La lista está vacía)");
                return;
            }
            while (actual != null) {
                System.out.print(actual.palabra + " ");
                actual = actual.siguiente;
            }
            System.out.println();
        }

        
        public String convertirATexto() {
            StringBuilder sb = new StringBuilder();
            Nodo actual = cabeza;
            while (actual != null) {
                sb.append(actual.palabra).append(" ");
                actual = actual.siguiente;
            }
            return sb.toString().trim();
        }

        public boolean estaVacia() {
            return cabeza == null;
        }
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        String nombreArchivo = "palabras.txt";

        
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                for (String p : palabras) {
                    if (!p.isEmpty()) {
                        lista.insertar(p);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException e) {
            System.out.println("⚠️ Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("\n📖 Palabras cargadas desde el archivo:");
        lista.mostrar();

        
        int opcion;
        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Agregar palabra");
            System.out.println("2. Eliminar palabra");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Guardar y salir");
            System.out.print("Seleccione una opción: ");
            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la palabra a agregar: ");
                    String nueva = sc.nextLine();
                    lista.insertar(nueva);
                    System.out.println(" Palabra agregada correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese la palabra a eliminar: ");
                    String eliminar = sc.nextLine();
                    if (lista.eliminar(eliminar)) {
                        System.out.println(" Palabra eliminada con éxito.");
                    } else {
                        System.out.println(" No se encontró la palabra en la lista.");
                    }
                    break;

                case 3:
                    System.out.println("\n Lista actual:");
                    lista.mostrar();
                    break;

                case 4:
                    
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
                        bw.write(lista.convertirATexto());
                        System.out.println(" Cambios guardados correctamente en el archivo.");
                    } catch (IOException e) {
                        System.out.println(" Error al guardar el archivo: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        sc.close();
        System.out.println("\n Programa finalizado .");
    }
}
