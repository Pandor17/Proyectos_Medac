import java.util.Scanner;

public class Ejercicio4 {
    public static void  main(String[] args){
        int[] xiNumero= new int[10];
        int iNumero;
        Scanner escaner = new Scanner(System.in);
        System.out.println("Introduzca 5 números en orden creciente ");
        for (int i = 0;i<5;i++){
            xiNumero[i]=escaner.nextInt();
        }
        System.out.println("Introduzca un nuevo número");
        iNumero=escaner.nextInt();
        int iposicion=5;
        for(int i=0;i<5;i++){
            if (iNumero>=xiNumero[i] && iNumero<=xiNumero[i+1]){
                iposicion=i+1;
            }

        }

        //corro los valores y meto el nuevo en caso de que haya entrado en mitad
           for (int i = 5; i > iposicion; i--) { //0-1-2-3-4- - -
               xiNumero[i] = xiNumero[i - 1];
           }
        xiNumero[iposicion]=iNumero;
        Ejercicio2.imprimir_arreglo_enteros(xiNumero);
    }
}
