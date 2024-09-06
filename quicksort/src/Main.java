import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner entrada = new Scanner(System.in);
//        System.out.println("¿Qué tamaño tiene el array?");
//        int iTamano = entrada.nextInt();
//        int[] inumero = new int[iTamano]; //Creo y relleno el array
//        System.out.println("Digite los números.");
//        for(int i = 0 ; i<iTamano ; i++){
//            System.out.print((i+1)+"º número: ");
//            inumero[i] = entrada.nextInt();
//        }
//
//        Quicksort.quicksort(inumero,0,iTamano-1);
//        System.out.print("El array ordenado queda así: ");
//        for(int i = 0 ; i<iTamano ; i++){
//            System.out.print(inumero[i]+" ");
//        }
        class Animal {
            void hacerSonido() {
                System.out.println("Sonido de Animal");
            }
        }

        class Perro extends Animal {
            void hacerSonido() {
                System.out.println("Guau Guau");
            }
        }

        Animal animal = new Perro();
        animal.hacerSonido(); // Se decide en tiempo de ejecución (polimorfismo dinámico)
    }
}
