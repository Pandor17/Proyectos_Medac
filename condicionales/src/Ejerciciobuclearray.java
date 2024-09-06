    //Directivas
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Ejerciciobuclearray {


    //main
    public static void main(String[] args){
        Scanner escaner = new Scanner(System.in);
        Random aleatorio = new Random();
        int[] xinumero = new int[5];
        int opcion=0;
        for(int i = 0; i<5 ; i++){
            xinumero[i]= (int)(aleatorio.nextDouble()*11+1);
        }
        do{
            System.out.println("Bienvenido a este programa. Elija lo que estime oportuno.\n" +
                    "1. Mostrar los 50 números en pantalla.\n" +
                    "2. Mostrar los 50 números en orden inverso.\n" +
                    "3. Buscar número menor.\n" +
                    "4. Buscar número mayor.\n" +
                    "5. Buscar y localizar un número.\n" +
                    "6. Cambiar un valor\n" +
                    "0. Salir\n");
            opcion = escaner.nextInt();
            switch(opcion){
                case 1: mostrararray(xinumero);
                    break;
                case 2: mostrararrayinverso(xinumero);
                    break;
                case 3: System.out.println("El número más pequeño es: "+numeromenor(xinumero));
                    break;
                case 4:
                    System.out.println("El número mayor es: "+ numeromayor(xinumero));
                    break;
                case 5:
                    int buscar;
                    boolean encontrado;
                    System.out.println("Ingrese el número a buscar");
                    buscar = escaner.nextInt();
                    encontrado = buscarysituar(xinumero,buscar);
                    if (!encontrado){
                        System.out.println("el número no se ha encontrado");
                    }
                    break;
                case 6:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("El número introducido no coincide con las opciones disponibles.\n");
            }
        }while(opcion!=0);
    }
    //definicion de
    public static void mostrararray (int[] xiNumero){
        for(int i : xiNumero) {
            System.out.println(i);
        }
    }

    public static void ordenararray (int[] xiNumero){
        for (int i=1; i < xiNumero.length-1; i++){
            for (int y=0; y < xiNumero.length-i ; y++){
                if (xiNumero[y] > xiNumero[y+1]) {
                    int aux = xiNumero[y];
                    xiNumero[y] = xiNumero[y + 1];
                    xiNumero[y + 1] = aux;
                }
            }
        }
    }

    public static void mostrararrayinverso (int[] xiNumero){
        ordenararray(xiNumero);
        for(int j=xiNumero.length-1 ; j>=0 ; j--){
            System.out.println(xiNumero[j]);
        }
    }

    public static int numeromenor (int[] xiNumero){
        ordenararray(xiNumero);
        return xiNumero[0];
    }

    public static int numeromayor (int[] xiNumero){
        int iMayor = xiNumero[0];
        for (int i = 1 ; i < xiNumero.length ; i++){
            if (iMayor<xiNumero[i]){
                iMayor=xiNumero[i];
            }
        }
        return iMayor;
    }

    public static boolean buscarysituar (int[] xiNumero,int x){
        boolean encontrado = false;
        for (int i = 0 ; i < xiNumero.length ; i++){
            if(x==xiNumero[i]){
                System.out.println("el numero ha sido encontrado en la posición "+i);
                return true;
            }
        }
        return false;
    }

    public static void cambiarvalor (){

    }

}
