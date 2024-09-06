
import java.util.Scanner;


public class Ejercicio3 {
    public static void main (String[] args){
        int[] xiNumero = {1,2,3,4,5,6,7,8,9,10};
        Scanner escaner = new Scanner(System.in);
        int iposicion,inumero;

        //nuevo número
        System.out.print("Digite un nuevo número: ");
        inumero = escaner.nextInt();
        System.out.print("Digite la posición en donde desea guardarlo: ");
        iposicion = escaner.nextInt();

        //sustituuendo
        for (int i = xiNumero.length-1; i>iposicion ; i--){
            xiNumero[i]=xiNumero[i-1];
        }
        xiNumero[iposicion]=inumero;

        //imprimiendo
        Ejercicio2.imprimir_arreglo_enteros(xiNumero);
    }
}
