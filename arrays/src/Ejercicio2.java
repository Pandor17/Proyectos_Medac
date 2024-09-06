import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args){
        int[] xinumero1 = new int[10];
        int[] xinumero2 = new int[10];
        int[] xinumero3 = new int[20];
        int icontador=0;
 
        //leyendo arrays
        System.out.println("Digite los numeros del primer array:");
        leer_arreglo_enteros(xinumero1);
        System.out.println("Digite los numeros del segundo array:");
        leer_arreglo_enteros(xinumero2);

        //guardar los del 1 dentro del 3 array
        for (int i=0;i<xinumero3.length;i+=2){
            xinumero3[i]=xinumero1[icontador];
            xinumero3[i+1]=xinumero2[icontador];
            icontador++;


        }
        System.out.println("Los numeros del 3º array son:");
        imprimir_arreglo_enteros(xinumero3);
    }

    //Método leer array
    public static void leer_arreglo_enteros(int[] xiNumero){
        Scanner escaner = new Scanner(System.in);
        for (int i=0;i< xiNumero.length;i++){
            xiNumero[i] = escaner.nextInt();

        }

    }
    //Método imprimir un arra
    public static void imprimir_arreglo_enteros(int[] xiNumero){
        for(int i:xiNumero){
            System.out.print(i+" ");
        }
    }
        
}
