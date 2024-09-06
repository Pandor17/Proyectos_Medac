
import java.util.*;
    public class a {
        public static void main(String[] args) {
            int[] numeros = new int[10];  // Declaración de variables
            int pares = 0;
            int impares = 0;
            // Entrada de números por teclado
            System.out.println("Ingresa 10 números enteros:");
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 10; i++) {
                numeros[i] = scanner.nextInt();
            }
            // Ordenar el array de menor a mayor
            Arrays.sort(numeros);
            // Mostrar números ordenados
            System.out.println("Números ordenados de menor a mayor:");
            for (int numero : numeros) {
                System.out.print(numero + " ");
            }
            System.out.println("\n");
            // Contar pares e impares
            for (int numero : numeros) {
                if (numero % 2 == 0) {
                    pares++;
                } else {impares++;}
            }
            // Mostrar cantidad de pares e impares
            System.out.println("Cantidad de números pares: " + pares);
            System.out.println("Cantidad de números impares: " + impares);
        }
    }


